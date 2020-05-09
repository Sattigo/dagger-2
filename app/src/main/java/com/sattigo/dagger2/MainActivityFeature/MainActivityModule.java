package com.sattigo.dagger2.MainActivityFeature;

import com.sattigo.dagger2.MainActivity;
import com.sattigo.dagger2.adapter.RandomUserAdapter;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hari on 20/12/17.
 */
@Module
public class MainActivityModule {

    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public RandomUserAdapter randomUserAdapter(Picasso picasso){
        return new RandomUserAdapter(mainActivity, picasso);
    }
}
