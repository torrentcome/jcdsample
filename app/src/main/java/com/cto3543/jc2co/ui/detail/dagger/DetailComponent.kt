package com.cto3543.jc2co.ui.detail.dagger

import com.cto3543.jc2co.ui.DetailActivity
import dagger.Component

@Component(modules = [(DetailModule::class)])
interface DetailComponent {
    fun inject(context: DetailActivity)
}
