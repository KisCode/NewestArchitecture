package com.keno.architecture.weather.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.keno.architecture.weather.model.Weather;
import com.keno.architecture.weather.request.OnLoadWeatherCallBack;
import com.keno.architecture.weather.request.QueryWeatherRequest;

public class QueryWeatherViewModel {
    private static final String TAG = "QueryWeatherViewModel";

    private QueryWeatherRequest queryWeatherRequest = new QueryWeatherRequest();

    public final ObservableBoolean isLoading = new ObservableBoolean(false); //初始化
    public final ObservableBoolean loadingSuccess = new ObservableBoolean(true); //初始化

    public final ObservableField<String> city = new ObservableField<>();

    public final ObservableField<String> weatherInfo = new ObservableField<>();

    public final ObservableField<String> tem1 = new ObservableField<>();
    public final ObservableField<String> tem2 = new ObservableField<>();


    public QueryWeatherViewModel() {
    }

    public void queryWeatherInfo() {
        isLoading.set(true);
        city.set("");
        weatherInfo.set("");
        tem1.set("");
        tem2.set("");

        queryWeatherRequest.queryWeather(new OnLoadWeatherCallBack() {
            @Override
            public void loadComplete(Weather weather) {
                isLoading.set(false);
                loadingSuccess.set(true);
                if (weather == null || weather.getWeatherinfo() == null) {
                    return;
                }

                city.set(weather.getWeatherinfo().getCity());
                weatherInfo.set(weather.getWeatherinfo().getWeather());
                tem1.set(weather.getWeatherinfo().getTemp1());
                tem2.set(weather.getWeatherinfo().getTemp2());
            }

            @Override
            public void loadFailure(Throwable throwable) {
                isLoading.set(false);
                loadingSuccess.set(false);
            }
        });
    }
}
