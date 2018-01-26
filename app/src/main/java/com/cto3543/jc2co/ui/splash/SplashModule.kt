package com.cto3543.jc2co.ui.splash

import com.cto3543.jc2co.inject.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class SplashModule {
    @ActivityScope
    @Provides
    fun providePresenter(): SplashPresenter {
        return SplashPresenter()
    }
}