package com.keno.architecture;


import com.keno.architecture.pojo.Weather;

import java.lang.ref.WeakReference;


/****
 * Description: 
 * Author:  keno
 * CreateDate: 2020/11/29 15:53
 */

public class QueryWeatherPresenter implements QueryWeatherContract.IPresenter {
    private QueryWeatherContract.IView view;
    private QueryWeatherModel model;

    private WeakReference<QueryWeatherContract.IView> vWeakReference;

    public QueryWeatherPresenter(QueryWeatherContract.IView view) {
        this.view = view;
        this.model = new QueryWeatherModel(this);
        vWeakReference = new WeakReference<>(view);
    }

    @Override
    public void requestWeather() {
        view.showLoading();
        model.requestWeather();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void responseData(int code, Weather weather) {
        view.dismissLoadding();

        if (code == Constant.CODE_SUCCESS) {
            view.showData(weather);
        } else {
            view.showErro(code);
        }

    }

    @Override
    public void unBind() {
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference = null;
            System.gc();
        }
    }
}
