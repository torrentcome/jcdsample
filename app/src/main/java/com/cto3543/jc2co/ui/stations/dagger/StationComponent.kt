package com.cto3543.jc2co.ui.stations.dagger

import com.cto3543.jc2co.inject.AppComponent
import com.cto3543.jc2co.ui.MainActivity
import dagger.Component

@StationScope
@Component(dependencies = [(AppComponent::class)], modules = [(StationModule::class)])
interface StationComponent {
    fun inject(context: MainActivity)
}
