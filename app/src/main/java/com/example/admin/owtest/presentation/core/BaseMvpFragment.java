package com.example.admin.owtest.presentation.core;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.admin.owtest.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseMvpFragment extends MvpAppCompatFragment {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Unbinder unbinder;

    //    protected abstract BasePresenter getPresenter();
    @Nullable
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    protected final void unsubscribeOnDestroy(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected final void unsubscribeOnDestroy(List<Disposable> disposables) {
        compositeDisposable.addAll(disposables.toArray(new Disposable[disposables.size()]));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResourceId(), container, false);
    }

    @LayoutRes
    protected abstract int getLayoutResourceId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (toolbar != null) {
            setupToolbar(toolbar);
        }
    }

    protected void setupToolbar(Toolbar toolbar) {
    }

    private final void checkToolbar(Runnable runnable) {
        if (toolbar == null) {
            Log.d("Error", "toolbar null");
        }
        runnable.run();
    }

    protected final void setTitleToolbar(final String title) {
        checkToolbar(() -> toolbar.setTitle(title));
    }

    protected final void setMenuToolbar(@MenuRes int menuToolbar) {
        checkToolbar(() -> {
            toolbar.getMenu().clear();
            if (menuToolbar != 0) {
                toolbar.inflateMenu(menuToolbar);
            }
        });
    }

    protected final void setNavigationIconToolbar(@DrawableRes int icon) {
        checkToolbar(() -> {
            if (icon == 0) {
                toolbar.setNavigationIcon(null);
            } else {
                toolbar.setNavigationIcon(icon);
            }
        });
    }

    protected final void hideNavigationIcon() {
        checkToolbar(() -> toolbar.setNavigationIcon(null));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(null);
            toolbar.setOnMenuItemClickListener(null);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
        unbinder.unbind();
    }
}
