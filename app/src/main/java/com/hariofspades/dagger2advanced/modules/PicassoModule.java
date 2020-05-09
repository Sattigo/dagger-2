package com.hariofspades.dagger2advanced.modules;

import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScope;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = OkHttpModule.class)
public class PicassoModule {

    @RandomUserApplicationScope
    @Provides
    public Picasso picasso(@Named("activity_context") Context context, OkHttp3Downloader okHttpDownloader) {
        return new Picasso
                .Builder(context)
                .downloader(okHttpDownloader)
                .build();
    }

    @Provides
    public OkHttp3Downloader okHttpDownloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
