package com.cto3543.jc2co.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import com.cto3543.jc2co.App
import com.cto3543.jc2co.model.Station
import com.cto3543.jc2co.ui.stations.core.StationListPresenter
import com.cto3543.jc2co.ui.stations.core.StationListView
import com.cto3543.jc2co.ui.stations.dagger.DaggerStationComponent
import com.cto3543.jc2co.ui.stations.dagger.StationModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var view: StationListView
    @Inject
    lateinit var presenter: StationListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerStationComponent.builder().appComponent((application as App).getNetComponent()).stationModule(StationModule(this)).build().inject(this)
        setContentView(view.view)
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    fun goToDetailActivity(station: Station) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("station", station as Parcelable)
        startActivity(intent)
    }
}
