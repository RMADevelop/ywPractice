package com.example.admin.owtest.di;

import com.example.admin.owtest.App;
import com.example.admin.owtest.di.components.AppComponent;
import com.example.admin.owtest.di.components.DaggerAppComponent;
import com.example.admin.owtest.di.components.HomeComponent;
import com.example.admin.owtest.di.components.LentaComponent;
import com.example.admin.owtest.di.components.PageContainerComponent;
import com.example.admin.owtest.di.modules.AppModule;

import lombok.Getter;

public class ComponentManager {

    private static ComponentManager instance;

    @Getter
    private AppComponent appComponent;

    private ComponentManager() {
    }

    public static ComponentManager getInstance() {
        if (instance == null) {
            instance = new ComponentManager();
        }
        return instance;
    }

    public void initComponentManager(App app) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(app))
                .build();
    }

    public HomeComponent getMainComponent() {
        return appComponent.plusMainComponent();
    }

    public PageContainerComponent getMainPagerComponent() {
        return appComponent.plusMainPagerComponent();
    }

    public LentaComponent getLentaComponent() {
        return appComponent.plusLentaComponent();
    }
}

