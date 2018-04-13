package com.example.admin.owtest.presentation.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.admin.owtest.R;
import com.example.admin.owtest.presentation.mainPage.MainPager;

import ru.terrakok.cicerone.android.SupportAppNavigator;

import static com.example.admin.owtest.presentation.main.NavigatorScreenKeys.MAIN;
import static com.example.admin.owtest.presentation.main.NavigatorScreenKeys.MAIN_PAGER;

public class AppNavigator extends SupportAppNavigator {

    private static final int ROOT_CONTAINER_ID = 1;

    @IdRes
    private static final int TAB_CONTAINER_ID = R.id.tab_container;

    @IdRes
    private static final int CHILD_CONTAINER_ID = R.id.child_container;

    private final FragmentManager fragmentManager;
    private final FragmentActivity fragmentActivity;

    public AppNavigator(FragmentActivity activity, int containerId, FragmentManager fragmentManager) {
        super(activity, containerId);
        this.fragmentManager = fragmentManager;
        this.fragmentActivity = activity;
    }

    @Override
    protected Intent createActivityIntent(String screenKey, Object data) {
        return null;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        Bundle bundle = getBundle(data);
        switch (screenKey) {
            case MAIN:
                return putArguments(new MainPager(), bundle);
            case MAIN_PAGER:
                return putArguments(new MainPager(), bundle);
        }
        return null;
    }

    private Fragment putArguments(Fragment fragment, Bundle bundle) {
        fragment.setArguments(bundle);
        return fragment;
    }

    private Bundle getBundle(Object data) {
        return (Bundle) data;
    }

}
