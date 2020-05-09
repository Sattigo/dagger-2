package com.sattigo.dagger2.MainActivityFeature;

import com.sattigo.dagger2.MainActivity;
import com.sattigo.dagger2.component.RandomUserComponent;

import dagger.Component;

/**
 * Created by Hari on 20/12/17.
 */
@Component(modules = MainActivityModule.class, dependencies = RandomUserComponent.class)
@MainActivityScope
public interface MainActivityComponent {

    void injectMainActivity(MainActivity mainActivity);

}
