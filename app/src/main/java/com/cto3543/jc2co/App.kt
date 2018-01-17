package com.cto3543.jc2co

import android.app.Application
import com.cto3543.jc2co.inject.AppComponent
import com.cto3543.jc2co.inject.AppContextModule
import com.cto3543.jc2co.inject.DaggerAppComponent
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appContextModule(AppContextModule(this)).build()
    }

    fun getNetComponent(): AppComponent {
        return appComponent
    }
}