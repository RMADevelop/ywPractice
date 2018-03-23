package com.example.admin.owtest.presentation.core;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.admin.owtest.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import ru.terrakok.cicerone.Navigator;

public abstract class BaseActivity extends MvpAppCompatActivity {

    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Unbinder unbinder;

    protected abstract BasePresenter getPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    protected abstract Navigator getNavigator();

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.getInstance()
                .getCicerone()
                .getNavigatorHolder()
                .setNavigator(getNavigator());
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.getInstance()
                .getCicerone()
                .getNavigatorHolder()
                .removeNavigator();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        compositeDisposable.dispose();
    }
}
