package com.cto3543.jc2co.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cto3543.jc2co.App
import com.cto3543.jc2co.R
import com.cto3543.jc2co.model.Station
import com.cto3543.jc2co.ui.Constant.Companion.KEY_STATION
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail_station.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailContract.View {
    @Inject
    lateinit var detailPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        DaggerDetailComponent.builder()
                .appComponent((application as App).appComponent())
                .detailModule(DetailModule())
                .build()
                .inject(this)

        detailPresenter.attachView(this)
        initUi()
    }

    override fun onDestroy() {
        super.onDestroy()
        detailPresenter.detachView()
    }

    private fun initUi() {
        val station = intent.getParcelableExtra<Station>(KEY_STATION)
        detailPresenter.load(station)
    }

    override fun load(res: Station) {
        toolbar.title = res.name
        number2.text = res.status
        address2.text = res.address
        bike_stands2.text = res.bike_stands.toString()
        available_bike_stands2.text = res.available_bike_stands.toString()
        available_bikes2.text = res.available_bikes.toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun showError(error: String) {
    }
}
