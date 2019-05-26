package com.keno.architecture.weather.request;

import com.keno.architecture.weather.model.Weather;

public interface OnLoadWeatherCallBack {
    void loadComplete(Weather weather);

    void loadFailure(Throwable throwable);
}
