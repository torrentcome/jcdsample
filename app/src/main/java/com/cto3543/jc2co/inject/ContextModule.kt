package com.cto3543.jc2co.inject

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val context: Context) {
    @Provides
    internal fun provideAppContext(): Context {
        return context
    }
}
