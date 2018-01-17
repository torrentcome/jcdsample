package com.cto3543.jc2co.ui.stations.core

import com.cto3543.jc2co.api.ApiServiceInterface
import com.cto3543.jc2co.model.Station
import com.cto3543.jc2co.ui.MainActivity
import io.reactivex.Observable

class StationListModel(internal var context: MainActivity, internal var api: ApiServiceInterface) {
    fun provideListStation(): Observable<List<Station>> {
        return api.getStations()
    }

    fun gotoStationDetailsActivity(station: Station) {
        context.goToDetailActivity(station)
    }
}