package com.example.admin.owtest.di.components;

import com.example.admin.owtest.di.modules.WeatherDetailModule;
import com.example.admin.owtest.di.scopes.PresenterScope;
import com.example.admin.owtest.presentation.weatherDetail.WeatherDetailPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {
        WeatherDetailModule.class
})
@PresenterScope
public interface WeatherDetailComponent {

    WeatherDetailPresenter getPresenter();
}
