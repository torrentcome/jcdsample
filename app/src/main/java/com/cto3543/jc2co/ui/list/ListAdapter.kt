package com.cto3543.jc2co.ui.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.cto3543.jc2co.R
import com.cto3543.jc2co.extention.inflate
import com.cto3543.jc2co.model.Station
import kotlinx.android.synthetic.main.item_title_station.view.*

class StationAdapter(private val list: List<Station>, private val listener: (Station) -> Unit) : RecyclerView.Adapter<StationAdapter.StationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder = StationViewHolder(parent.inflate(R.layout.item_title_station, false))
    override fun onBindViewHolder(holder: StationViewHolder, position: Int) = holder.bind(list[position], listener)
    override fun getItemCount(): Int = list.size
    class StationViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind(station: Station, listener: (Station) -> Unit) = with(itemView) {
            name.text = station.name
            contract_name.text = station.contract_name
            setOnClickListener({
                listener(station)
            })
        }
    }
}


