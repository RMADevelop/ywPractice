package com.example.admin.owtest.presentation.main;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.admin.owtest.R;
import com.example.admin.owtest.di.ComponentManager;
import com.example.admin.owtest.presentation.core.BaseActivity;
import com.example.admin.owtest.presentation.core.BasePresenter;
import com.example.admin.owtest.presentation.mainPage.MainPager;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.commands.Replace;

import static com.example.admin.owtest.presentation.main.NavigatorScreenKeys.MAIN_PAGER;

public class Activity extends BaseActivity implements MainView, MainPager.OnFragmentInteractionListener {

    private final AppNavigator navigator = new AppNavigator(this,
            R.id.main_container,
            getSupportFragmentManager());

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_container)
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Inject
    NavigatorHolder navigatorHolder;

    @Inject
    Provider<MainPresenter> provider;

    @InjectPresenter
    MainPresenter mainPresenter;

    @ProvidePresenter
    MainPresenter providePresenter() {
        return provider.get();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ComponentManager.getInstance()
                .getMainComponent()
                .inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initToolbar();

        navigator.createFragment(MAIN_PAGER, new Bundle());
        navigator.applyCommand(new Replace(MAIN_PAGER, new Bundle()));

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void initToolbar() {
        toolbar.setTitle("Диск");
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected BasePresenter getPresenter() {
        return mainPresenter;
    }

    @Override
    protected Navigator getNavigator() {
        return navigator;
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
