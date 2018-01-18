package com.cto3543.jc2co.inject

import android.content.Context
import com.cto3543.jc2co.R
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

@Module
class NetworkModule {
    @AppScope
    @Provides
    fun provideHttpClient(context: Context, logger: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        builder.addInterceptor(logger)
        builder.cache(cache)
        builder.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()
            val url = originalHttpUrl.newBuilder().addQueryParameter("apiKey", context.resources.getString(R.string.API_KEY)).build()
            val requestBuilder = original.newBuilder().url(url)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        return builder.build()
    }

    @AppScope
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    fun provideCache(file: File): Cache {
        return Cache(file, (10 * 10 * 1000).toLong())
    }

    @AppScope
    @Provides
    fun provideCacheFile(context: Context): File {
        return context.filesDir
    }

    @AppScope
    @Provides
    fun provideRxAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @AppScope
    @Provides
    fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}