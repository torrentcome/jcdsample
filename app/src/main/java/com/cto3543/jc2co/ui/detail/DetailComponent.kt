package com.cto3543.jc2co.ui.detail

import com.cto3543.jc2co.inject.ActivityScope
import com.cto3543.jc2co.inject.AppComponent
import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(DetailModule::class)])
interface DetailComponent {
    fun inject(context: DetailActivity)
}
