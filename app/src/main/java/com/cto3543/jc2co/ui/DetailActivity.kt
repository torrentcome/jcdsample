package com.cto3543.jc2co.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cto3543.jc2co.model.Station
import com.cto3543.jc2co.ui.detail.core.DetailView
import com.cto3543.jc2co.ui.detail.dagger.DaggerDetailComponent
import com.cto3543.jc2co.ui.detail.dagger.DetailModule
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var view: DetailView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val station = intent.extras!!.get("station") as Station
        DaggerDetailComponent.builder().detailModule(DetailModule(this, station)).build().inject(this)
        setContentView(view.view)
        setSupportActionBar(view.toolbar)
        toolbarOpts()
    }

    private fun toolbarOpts() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
