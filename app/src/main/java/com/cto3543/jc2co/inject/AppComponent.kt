package com.cto3543.jc2co.inject

import com.cto3543.jc2co.api.ApiService
import dagger.Component

@AppScope
@Component(modules = [(ContextModule::class), (NetworkModule::class), (ApiModule::class)])
interface AppComponent {
    fun apiService(): ApiService
}