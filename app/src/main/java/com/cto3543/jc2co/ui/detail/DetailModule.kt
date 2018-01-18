package com.cto3543.jc2co.ui.detail

import com.cto3543.jc2co.inject.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class DetailModule {
    @ActivityScope
    @Provides
    fun providePresenter(): DetailPresenter {
        return DetailPresenter()
    }
}