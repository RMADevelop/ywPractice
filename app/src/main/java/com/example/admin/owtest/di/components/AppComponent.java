package com.example.admin.owtest.di.components;

import com.example.admin.owtest.di.modules.AppModule;
import com.example.admin.owtest.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        NetworkModule.class
})
@Singleton
public interface AppComponent {

    WeatherDetailComponent plusWeatherDetailComponent();
}
