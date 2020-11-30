package com.keno.architecture.weather;


import com.keno.architecture.base.BaseEntity;

/****
 * Description: 将Model、View、Presenter层协商共同业务，封装成接口
 * Author:  keno
 * CreateDate: 2020/11/30 21:45
 */
public interface WeatherContract {
    interface Model {
        void requestWeather();
    }

    interface View<T extends BaseEntity> {
        void hanleResult(T t);
    }

    interface Presenter<T> {
        //接收View层指令，可以在P层做，也可以在Model层做
        void requestWeather();

        void responseResult(T t);
    }
}

