package com.cto3543.jc2co.ui.stations.dagger

import com.cto3543.jc2co.api.ApiServiceInterface
import com.cto3543.jc2co.ui.MainActivity
import com.cto3543.jc2co.ui.stations.core.StationListModel
import com.cto3543.jc2co.ui.stations.core.StationListPresenter
import com.cto3543.jc2co.ui.stations.core.StationListView
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class StationModule(var context: MainActivity) {
    @StationScope
    @Provides
    fun provideView(): StationListView {
        return StationListView(context)
    }

    @StationScope
    @Provides
    fun providePresenter(view: StationListView, model: StationListModel): StationListPresenter {
        val subscriptions = CompositeDisposable()
        return StationListPresenter(model, view, subscriptions)
    }

    @StationScope
    @Provides
    fun provideContext(): MainActivity {
        return context
    }

    @StationScope
    @Provides
    fun provideModel(api: ApiServiceInterface): StationListModel {
        return StationListModel(context, api)
    }
}