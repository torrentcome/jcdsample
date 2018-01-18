package com.cto3543.jc2co.ui.list

import com.cto3543.jc2co.api.ApiService
import com.cto3543.jc2co.extention.void
import com.cto3543.jc2co.extention.voidBoolean
import com.cto3543.jc2co.model.Station
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ListPresenter(val api: ApiService) : ListContract.Presenter {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var view: ListContract.View? = null
    override fun attachView(view: ListContract.View) {
        this.view = view
    }

    override fun detachView() {
        compositeDisposable.dispose()
        this.view = null
    }

    override fun loadRes() {
        view?.showProgress(true)
        api.getStations()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        object : Observer<List<Station>> {
                            override fun onComplete() = view?.showProgress(false).void()
                            override fun onNext(t: List<Station>) = view?.showRes(t).void()
                            override fun onError(e: Throwable) = view?.showError(e.toString()).void()
                            override fun onSubscribe(d: Disposable) = compositeDisposable.add(d).voidBoolean()
                        })
    }
}

