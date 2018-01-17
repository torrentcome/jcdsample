package com.cto3543.jc2co.ui.stations.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cto3543.jc2co.R
import com.cto3543.jc2co.extention.inflate
import com.cto3543.jc2co.model.Station
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_title_station.view.*
import java.util.*

class StationAdapter(private val list: MutableList<Station>) : RecyclerView.Adapter<StationViewHolder>() {
    private val itemClicks: PublishSubject<Station> = PublishSubject.create()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val inflatedView: View = parent.inflate(R.layout.item_title_station, false)
        return StationViewHolder(inflatedView, itemClicks)
    }

    override fun onBindViewHolder(holder: StationViewHolder?, position: Int) {
        holder?.bind(list[position])
    }

    override fun getItemCount(): Int {
        return if (list.size > 0) {
            list.size
        } else {
            0
        }
    }

    fun setList(stations: ArrayList<Station>) {
        list.clear()
        list.addAll(stations)
        notifyDataSetChanged()
    }

    fun observeClicks(): PublishSubject<Station> {
        return itemClicks
    }
}

class StationViewHolder(v: View, private var click: PublishSubject<Station>) : RecyclerView.ViewHolder(v) {
    internal var view: View = v
    @JvmField
    var name: TextView? = null

    fun bind(item: Station) {
        view.name.text = item.name
        view.contract_name.text = item.contract_name
        view.setOnClickListener({
            click.onNext(item)
        })
    }
}
