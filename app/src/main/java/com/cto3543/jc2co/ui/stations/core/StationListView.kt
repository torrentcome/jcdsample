package com.cto3543.jc2co.ui.stations.core

import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.cto3543.jc2co.R
import com.cto3543.jc2co.extention.inflate
import com.cto3543.jc2co.model.Station
import com.cto3543.jc2co.ui.MainActivity
import com.cto3543.jc2co.ui.stations.list.StationAdapter
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*

class StationListView(context: MainActivity) {
    var view: View? = null
    private var adapter: StationAdapter
    private val progressbar: ProgressBar
    fun itemClicks(): PublishSubject<Station> {
        return adapter.observeClicks()
    }

    fun view(): View? {
        return view
    }

    fun showProgress(show: Boolean) {
        when (show) {
            true -> progressbar.visibility = View.VISIBLE
            false -> progressbar.visibility = View.GONE
        }
    }

    fun setAdapter(list: ArrayList<Station>) {
        adapter.setList(list)
    }

    fun showErrorMessage(it: String) {
        view?.let { it1 -> Snackbar.make(it1, it, Snackbar.LENGTH_LONG).show() }
    }

    init {
        val frameLayout = FrameLayout(context)
        view = frameLayout.inflate(R.layout.activity_main, true)
        val list: RecyclerView = view!!.list
        progressbar = view!!.progressbar
        adapter = StationAdapter(arrayListOf())
        list.adapter = adapter
        val mLayoutManager = LinearLayoutManager(context)
        list.layoutManager = mLayoutManager
    }
}