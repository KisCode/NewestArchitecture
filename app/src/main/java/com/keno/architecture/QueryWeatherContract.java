package com.keno.architecture;


import com.keno.architecture.pojo.Weather;

/****
 * Description: 
 * Author:  keno
 * CreateDate: 2020/11/29 16:05
 */

public interface QueryWeatherContract {

    interface IPresenter {
        void requestWeather();

        void responseData(int code, Weather weather);

        void unBind();
    }

    interface IView {
        void showLoading();

        void showErro(int code);

        void showData(Weather weather);

        void dismissLoadding();
    }

    interface IModel {
        void requestWeather();
    }
}

