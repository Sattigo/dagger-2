package com.sattigo.dagger2.component;

import com.sattigo.dagger2.interfaces.RandomUserApplicationScope;
import com.sattigo.dagger2.interfaces.RandomUsersApi;
import com.sattigo.dagger2.module.PicassoModule;
import com.sattigo.dagger2.module.RandomUsersModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Hari on 23/11/17.
 */
@RandomUserApplicationScope
@Component(modules = {RandomUsersModule.class, PicassoModule.class})
public interface RandomUserComponent {

    RandomUsersApi getRandomUserService();

    Picasso getPicasso();
}
