package com.example.admin.owtest;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.admin.owtest.di.ComponentManager;

import lombok.Getter;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Router;

public class App extends Application {

    @Getter
    private static App instance;

    @Getter
    private Router router;

    @Getter
    private Cicerone<Router> cicerone;

    @Getter
    private SharedPreferences sharedPreferences;


    @Override
    public void onCreate() {
        super.onCreate();
        ComponentManager.getInstance()
                .initComponentManager(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }
}
