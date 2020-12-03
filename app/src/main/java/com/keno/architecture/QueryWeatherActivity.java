package com.keno.architecture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.keno.architecture.pojo.Weather;

/**
 * Description: 未封装的mvp使用Demo
 * Author: KENO
 * Date : 2020/11/30 7:03
 **/
public class QueryWeatherActivity extends AppCompatActivity implements QueryWeatherContract.IView, View.OnClickListener {

    QueryWeatherContract.IPresenter presenter;
    private TextView tvWeatherCity;
    private TextView tvWeatherTempLow;
    private TextView tvWeatherTemHeight;
    private TextView tvWeatherInfo;
    private TextView tvErroInfo;
    private Button btnQueryWeather;
    private ProgressBar pbarLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_weather);
        presenter = new QueryWeatherPresenter(this);
        initView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unBind();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_query_weather) {
            presenter.requestWeather();
        }
    }

    @Override
    public void showLoading() {
        pbarLoading.setVisibility(View.VISIBLE);
        tvErroInfo.setVisibility(View.VISIBLE);
        tvErroInfo.setText("loading...");

    }

    @Override
    public void showErro(int code) {
        tvErroInfo.setVisibility(View.VISIBLE);
        tvErroInfo.setText("load erro,please retry");
    }

    @Override
    public void showData(Weather weather) {
        tvWeatherCity.setText(weather.getWeatherinfo().getCity());
        tvWeatherTempLow.setText(weather.getWeatherinfo().getTemp1());
        tvWeatherTemHeight.setText(weather.getWeatherinfo().getTemp2());
        tvWeatherInfo.setText(weather.getWeatherinfo().getWeather());
    }

    @Override
    public void dismissLoadding() {
        pbarLoading.setVisibility(View.GONE);
        tvErroInfo.setVisibility(View.GONE);
    }

    private void initView() {
        tvWeatherCity = findViewById(R.id.tv_weather_city);
        tvWeatherTempLow = findViewById(R.id.tv_weather_temp_low);
        tvWeatherTemHeight = findViewById(R.id.tv_weather_tem_height);
        tvWeatherInfo = findViewById(R.id.tv_weather_info);
        btnQueryWeather = findViewById(R.id.btn_query_weather);
        pbarLoading = findViewById(R.id.pbar_loading);
        tvErroInfo = findViewById(R.id.tv_erro_info);

        btnQueryWeather.setOnClickListener(this);
    }
}
