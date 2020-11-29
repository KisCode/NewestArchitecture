package com.keno.architecture;


import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.keno.architecture.pojo.Weather;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/****
 * Description: 
 * Author:  keno
 * CreateDate: 2020/11/29 15:55
 */

public class QueryWeatherModel implements QueryWeatherContract.IModel {
    private QueryWeatherContract.IPresenter presenter;

    public QueryWeatherModel(QueryWeatherContract.IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestWeather() {
        final Handler handler = new Handler();
        String url = "http://www.weather.com.cn/data/cityinfo/101010100.html";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
//                Log.d(TAG, "onFailure: " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
//                Log.d(TAG, "onResponse: " + Thread.currentThread().getName());
                Log.d("onResponse", "onResponse: " + body);
                final Weather weather = JSON.parseObject(body, Weather.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        presenter.responseData(Constant.CODE_SUCCESS, weather);
                    }
                });
            }
        });
    }
}
