package com.cto3543.jc2co.inject;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }

}
