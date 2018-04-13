package com.example.admin.owtest.di.components;

import com.example.admin.owtest.di.modules.HomeModule;
import com.example.admin.owtest.di.scopes.PresenterScope;
import com.example.admin.owtest.presentation.main.Activity;

import dagger.Subcomponent;

@Subcomponent(modules = {
        HomeModule.class
})
@PresenterScope
public interface HomeComponent {

    void inject(Activity activity);
}
