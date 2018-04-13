package com.example.admin.owtest.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.admin.owtest.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

@Module
public class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return application.getSharedPreferences();
    }
}
