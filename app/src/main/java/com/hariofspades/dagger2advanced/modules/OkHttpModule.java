package com.hariofspades.dagger2advanced.modules;

import android.content.Context;

import java.io.File;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = ContextModule.class)
public class OkHttpModule {
    @Provides
    OkHttpClient okHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient()
                .newBuilder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000);
    }

    @Provides
    File file(@Named("application_context") Context context) {
        File file = new File(context.getCacheDir(), "HttpCache");
        if (file.mkdirs()) {
            return file;
        } else {
            return null;
        }
    }

    @Provides
    HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> {
            Timber.d(message);
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
