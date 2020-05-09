package com.hariofspades.dagger2advanced.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScope;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpModule.class)
public class RandomUserModule {
    @Provides
    public RandomUsersApi randomUsersApi(Retrofit retrofit) {
        return retrofit.create(RandomUsersApi.class);
    }

    @RandomUserApplicationScope
    @Provides
    Retrofit retrofit(OkHttpClient client, Gson gson, GsonConverterFactory factory) {
        return new Retrofit
                .Builder()
                .client(client)
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(factory)
                .build();
    }

    @Provides
    Gson gson() {
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
    }

    @Provides
    GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }
}
