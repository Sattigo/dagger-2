package com.hariofspades.dagger2advanced.interfaces;

import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.modules.PicassoModule;
import com.hariofspades.dagger2advanced.modules.RandomUserModule;
import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Component;

@RandomUserApplicationScope
@Component(modules = {RandomUserModule.class, PicassoModule.class})
public interface RandomUserComponent {
    @Named("application_context")
    Context getContext();
    RandomUsersApi getRandomUserService();
    Picasso getPicasso();
}
