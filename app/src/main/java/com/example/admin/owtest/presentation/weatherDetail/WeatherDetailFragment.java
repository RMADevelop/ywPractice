package com.example.admin.owtest.presentation.weatherDetail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.admin.owtest.R;
import com.example.admin.owtest.di.ComponentManager;
import com.example.admin.owtest.presentation.core.BaseMvpFragment;

import butterknife.BindView;

public class WeatherDetailFragment extends BaseMvpFragment implements WeatherDetailView {

    @BindView(R.id.image_view_weather_background)
    ImageView imageViewWeatherBackground;

    @BindView(R.id.text_view_temperature)
    TextView textViewTemperature;

    @BindView(R.id.image_view_temperature)
    ImageView imageViewTemperature;

    @BindView(R.id.text_view_weather_description)
    TextView textViewWeatherDescription;

    @BindView(R.id.recycler_view_day)
    RecyclerView recyclerViewDay;

    @BindView(R.id.recycler_view_week)
    RecyclerView recyclerViewWeek;

    @BindView(R.id.text_view_winds_speed)
    TextView textViewWindsSpeed;

    @BindView(R.id.text_view_pressure)
    TextView textViewPressuare;

    @BindView(R.id.text_view_wetness)
    TextView textViewWetness;

    @InjectPresenter
    WeatherDetailPresenter presenter;
    private WeatherDetailListener listener;

    public static WeatherDetailFragment newInstance() {
        WeatherDetailFragment fragment = new WeatherDetailFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    WeatherDetailPresenter providePresenter() {
        return ComponentManager.getInstance()
                .getWeatherDetailComponent()
                .getPresenter();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_weather_detail;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WeatherDetailListener) {
            listener = (WeatherDetailListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement WeatherDetailListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface WeatherDetailListener {
        void onFragmentInteraction(Uri uri);
    }
}
