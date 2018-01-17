package com.cto3543.jc2co.ui.detail.dagger

import com.cto3543.jc2co.model.Station
import com.cto3543.jc2co.ui.DetailActivity
import com.cto3543.jc2co.ui.detail.core.DetailView
import dagger.Module
import dagger.Provides

@Module
class DetailModule(var context: DetailActivity, var station: Station) {
    @DetailScope
    @Provides
    fun provideContext(): DetailActivity {
        return context
    }

    @Provides
    fun provideView(): DetailView {
        return DetailView(context, station)
    }
}