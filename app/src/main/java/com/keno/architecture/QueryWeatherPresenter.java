package com.keno.architecture;


import com.keno.architecture.pojo.Weather;


/****
 * Description: 
 * Author:  keno
 * CreateDate: 2020/11/29 15:53
 */

public class QueryWeatherPresenter implements QueryWeatherContract.IPresenter {
    private QueryWeatherContract.IView view;
    private QueryWeatherModel model;

    public QueryWeatherPresenter(QueryWeatherContract.IView view) {
        this.view = view;
        this.model = new QueryWeatherModel(this);
    }

    @Override
    public void requestWeather() {
        view.showLoading();
        model.requestWeather();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(60*1000);
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
}
