package com.cto3543.jc2co.api

import com.cto3543.jc2co.model.Station
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiServiceInterface {
    @GET("stations")
    fun getStations(): Observable<List<Station>>
    //@GET("stations")
    //fun getInfoStations(@Path("station_number") station_number: Int, @Query("contract") contract_name: String): Observable<Station>
}

class Constants {
    companion object {
        const val URL = "https://api.jcdecaux.com/vls/v1/"
        const val API_KEY = "825ecd95a483d2e1f851462e43fc7c86e3e8c80f"
    }
}