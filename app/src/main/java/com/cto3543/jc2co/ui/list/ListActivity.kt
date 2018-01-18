package com.cto3543.jc2co.ui.list

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.cto3543.jc2co.App
import com.cto3543.jc2co.R
import com.cto3543.jc2co.model.Station
import com.cto3543.jc2co.ui.Constant.Companion.KEY_STATION
import com.cto3543.jc2co.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListActivity : AppCompatActivity(), ListContract.View {
    @Inject
    lateinit var presenter: ListPresenter
    private lateinit var adapter: StationAdapter
    val res: MutableList<Station> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        DaggerListComponent.builder()
                .appComponent((application as App).appComponent())
                .listModule(ListModule())
                .build()
                .inject(this)
        initUi()
        presenter.attachView(this)
        presenter.loadRes()
    }

    private fun initUi() {
        adapter = StationAdapter(this.res) {
            goToDetailActivity(it)
        }

        list.adapter = adapter
        val mLayoutManager = LinearLayoutManager(this)
        list.layoutManager = mLayoutManager
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    private fun goToDetailActivity(station: Station) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(KEY_STATION, station as Parcelable)
        startActivity(intent)
    }

    override fun showError(error: String) {
        Snackbar.make(list, error, Snackbar.LENGTH_LONG).show()
    }

    override fun showRes(res: List<Station>) {
        this.res.clear()
        // sort list
        val sortedList = ArrayList(res.sortedWith(compareBy({ it.contract_name }, { it.name })))
        this.res.addAll(sortedList)
        adapter.notifyDataSetChanged()
    }

    override fun showProgress(show: Boolean) {
        when (show) {
            true -> progressbar.visibility = View.VISIBLE
            false -> progressbar.visibility = View.GONE
        }
    }
}
