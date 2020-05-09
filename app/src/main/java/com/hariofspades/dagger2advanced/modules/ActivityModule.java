package com.hariofspades.dagger2advanced.modules;

import android.app.Activity;
import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Context context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @Named("activity_context")
    @RandomUserApplicationScope
    @Provides
    public Context context() {
        return context;
    }
}
