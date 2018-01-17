package com.cto3543.jc2co.inject

import com.cto3543.jc2co.api.ApiServiceInterface
import com.cto3543.jc2co.api.Constants.Companion.URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiServiceModule {
    @AppScope
    @Provides
    fun provideApiService(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): ApiServiceInterface {
        val service: ApiServiceInterface
        val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxAdapter)
                .build()
        service = retrofit.create<ApiServiceInterface>(ApiServiceInterface::class.java)
        return service
    }
}