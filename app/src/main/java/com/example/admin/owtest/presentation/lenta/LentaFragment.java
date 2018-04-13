package com.example.admin.owtest.presentation.lenta;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.admin.owtest.R;
import com.example.admin.owtest.di.ComponentManager;
import com.example.admin.owtest.presentation.core.BaseMvpFragment;
import com.example.admin.owtest.presentation.lenta.adapter.PhotoRecyclerViewAdapter;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;

public class LentaFragment extends BaseMvpFragment implements LentaView , PhotoRecyclerViewAdapter.PhotoAdapterListener{

    private static final String ARG_PARAM1 = "param1";

    @BindView(R.id.text_view_value)
    TextView textViewValue;

    @BindView(R.id.recycler_view_photos)
    RecyclerView recyclerView;

    @Inject
    Provider<LentaPresenter> provider;

    @InjectPresenter
    LentaPresenter presenter;

    PhotoRecyclerViewAdapter adapter;

    public static LentaFragment newInstance() {
        LentaFragment fragment = new LentaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    LentaPresenter provideLentaPresenter() {
        return provider.get();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ComponentManager
                .getInstance()
                .getLentaComponent()
                .inject(this);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initRecycler();
    }

    private void initRecycler() {
        adapter = new PhotoRecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_lenta;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(int position) {
        Log.d("sdfsdfd", "onClick: " + position);
    }
}
