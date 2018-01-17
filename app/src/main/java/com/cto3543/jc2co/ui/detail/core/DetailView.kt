package com.cto3543.jc2co.ui.detail.core

import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.cto3543.jc2co.R
import com.cto3543.jc2co.extention.inflate
import com.cto3543.jc2co.model.Station
import com.cto3543.jc2co.ui.DetailActivity
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.activity_detail_station.view.*

class DetailView(context: DetailActivity, station: Station?) {
    var view: View? = null
    var toolbar: Toolbar
    private var number2: TextView
    private var name2: TextView
    private var address2: TextView
    private var bikeStands2: TextView
    private var availableBikeStands2: TextView
    private var availableBikes2: TextView
    fun view(): View? {
        return view
    }

    init {
        val frameLayout = FrameLayout(context)
        view = frameLayout.inflate(R.layout.activity_detail, true)
        toolbar = view!!.toolbar
        name2 = view!!.name2
        number2 = view!!.number2
        address2 = view!!.address2
        bikeStands2 = view!!.bike_stands2
        availableBikeStands2 = view!!.available_bike_stands2
        availableBikes2 = view!!.available_bikes2
        station?.let {
            toolbar.title = station.name
            number2.text = station.status
            address2.text = station.address
            bikeStands2.text = station.bike_stands.toString()
            availableBikeStands2.text = station.available_bike_stands.toString()
            availableBikes2.text = station.available_bikes.toString()
        }
    }
}