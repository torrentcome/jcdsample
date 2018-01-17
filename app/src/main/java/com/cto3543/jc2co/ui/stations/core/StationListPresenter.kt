package com.cto3543.jc2co.ui.stations.core

import com.cto3543.jc2co.model.Station
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class StationListPresenter(private var model: StationListModel, internal var view: StationListView, private var subscriptions: CompositeDisposable) {
    internal var stations = ArrayList<Station>()
    fun onCreate() {
        getList()?.let { subscriptions.add(it) }
        subscriptions.add(respondToClick())
    }

    fun onDestroy() {
        subscriptions.clear()
    }

    private fun getList(): Disposable? {
        val observable = model.api.getStations()
        val sub = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ stations: List<Station>? ->
            stations?.let {
                val sortedList = ArrayList(stations.sortedWith(compareBy({ it.contract_name }, { it.name })))
                view.setAdapter(sortedList)
                view.showProgress(false)
            }
        }, { err: Throwable? ->
            err?.message?.let {
                view.showErrorMessage(it)
                view.showProgress(false)
            }
        })
        return sub
    }

    private fun respondToClick(): Disposable {
        return view.itemClicks().subscribe({ t: Station? ->
            t?.let { model.gotoStationDetailsActivity(it) }
        })
    }
}
