package com.cto3543.jc2co

import android.app.Application
import com.cto3543.jc2co.inject.*
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .contextModule(ContextModule(this))
                .networkModule(NetworkModule())
                .apiModule(ApiModule())
                .build()
    }

    fun appComponent(): AppComponent {
        return appComponent
    }
}