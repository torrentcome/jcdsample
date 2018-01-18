package com.cto3543.jc2co.api

import com.cto3543.jc2co.model.Station
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @GET("stations")
 * fun getInfoStations(@Path("station_number") station_number: Int, @Query("contract") contract_name: String): Observable<Station>
 * */
interface ApiService {
    @GET("stations")
    fun getStations(): Observable<List<Station>>
}
