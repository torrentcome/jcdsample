package com.cto3543.jc2co.inject

import android.content.Context
import com.cto3543.jc2co.R
import com.cto3543.jc2co.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    @AppScope
    @Provides
    fun provideApiService(context: Context, client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): ApiService {
        val service: ApiService
        val retrofit = Retrofit.Builder()
                .baseUrl(context.resources.getString(R.string.URL))
                .client(client)
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxAdapter)
                .build()
        service = retrofit.create<ApiService>(ApiService::class.java)
        return service
    }
}