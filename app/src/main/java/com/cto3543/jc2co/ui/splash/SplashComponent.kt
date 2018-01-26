package com.cto3543.jc2co.ui.splash

import com.cto3543.jc2co.inject.ActivityScope
import com.cto3543.jc2co.inject.AppComponent
import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(SplashModule::class)])
interface SplashComponent {
    fun inject(context: SplashActivity)
}
