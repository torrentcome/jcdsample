package com.cto3543.jc2co.inject

import com.cto3543.jc2co.api.ApiServiceInterface
import dagger.Component

@AppScope
@Component(modules = [(AppContextModule::class), (ApiServiceConsModule::class), (ApiServiceModule::class)])
interface AppComponent {
    fun apiService(): ApiServiceInterface
}