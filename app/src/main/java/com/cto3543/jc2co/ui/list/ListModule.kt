package com.cto3543.jc2co.ui.list

import com.cto3543.jc2co.api.ApiService
import com.cto3543.jc2co.inject.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ListModule {
    @ActivityScope
    @Provides
    fun providePresenter(api: ApiService): ListPresenter {
        return ListPresenter(api)
    }
}