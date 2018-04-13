package com.example.admin.owtest.di.components;

import com.example.admin.owtest.di.modules.LentaModule;
import com.example.admin.owtest.presentation.lenta.LentaFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {
        LentaModule.class
})
public interface LentaComponent {

    void inject(LentaFragment lentaFragment);
}
