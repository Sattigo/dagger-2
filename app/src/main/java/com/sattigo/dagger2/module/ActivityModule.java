package com.sattigo.dagger2.module;

import android.app.Activity;
import android.content.Context;

import com.sattigo.dagger2.interfaces.RandomUserApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hari on 23/11/17.
 */
@Module
public class ActivityModule {

    private final Context context;

    ActivityModule(Activity context){
        this.context = context;
    }

    @Named("activity_context")
    @RandomUserApplicationScope
    @Provides
    public Context context(){ return context; }
}
