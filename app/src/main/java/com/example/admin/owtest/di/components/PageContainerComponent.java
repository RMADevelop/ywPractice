package com.example.admin.owtest.di.components;

import com.example.admin.owtest.di.modules.PageContainerModule;
import com.example.admin.owtest.di.scopes.PresenterScope;
import com.example.admin.owtest.presentation.mainPage.MainPager;

import dagger.Subcomponent;

@Subcomponent(modules = {
        PageContainerModule.class
})
@PresenterScope
public interface PageContainerComponent {

    void inject(MainPager mainPager);
}
