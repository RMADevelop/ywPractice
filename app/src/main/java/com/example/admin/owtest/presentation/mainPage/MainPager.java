package com.example.admin.owtest.presentation.mainPage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.admin.owtest.R;
import com.example.admin.owtest.di.ComponentManager;
import com.example.admin.owtest.presentation.core.BaseMvpFragment;
import com.example.admin.owtest.presentation.mainPage.adapter.PageADapter;

import javax.inject.Inject;

import butterknife.BindView;


public class MainPager extends BaseMvpFragment implements MainPagerView {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Inject
    @InjectPresenter
    MainPagerPresenter mainPagerPresenter;
    private PagerAdapter pagerAdapter;
    private OnFragmentInteractionListener mListener;

    public static MainPager newInstance(String param1, String param2) {
        MainPager fragment = new MainPager();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    MainPagerPresenter providePresenter() {
        return mainPagerPresenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentManager
                .getInstance()
                .getMainPagerComponent()
                .inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initTabLayout();
    }

    private void initTabLayout() {
        pagerAdapter = new PageADapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void setupToolbar(android.support.v7.widget.Toolbar toolbar) {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_main_pager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement LentaFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
