package com.cto3543.jc2co.ui.list

import com.cto3543.jc2co.inject.ActivityScope
import com.cto3543.jc2co.inject.AppComponent
import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(ListModule::class)])
interface ListComponent {
    fun inject(context: ListActivity)
}
