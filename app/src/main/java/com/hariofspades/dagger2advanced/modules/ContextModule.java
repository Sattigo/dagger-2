package com.hariofspades.dagger2advanced.modules;

import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Named("application_context")
    @RandomUserApplicationScope
    @Provides
    Context context() {
        return this.context.getApplicationContext();
    }
}
