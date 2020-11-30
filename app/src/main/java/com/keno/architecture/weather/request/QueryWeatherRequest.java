package com.keno.architecture.weather.request;


import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.keno.architecture.weather.model.Weather;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class QueryWeatherRequest {
    private static final String TAG = "QueryWeatherRequest";

    public void queryWeather(final OnLoadWeatherCallBack callBack) {
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
                Log.d(TAG, "onFailure: " + e.getLocalizedMessage());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.loadFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, "onResponse: " + Thread.currentThread().getName());
                Log.d(TAG, "onResponse: " + body);
                final Weather weather = JSON.parseObject(body, Weather.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.loadComplete(weather);
                    }
                });
            }
        });
    }
}
