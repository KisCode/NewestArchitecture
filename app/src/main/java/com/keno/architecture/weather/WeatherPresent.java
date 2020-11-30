package com.keno.architecture.weather;


import com.keno.architecture.base.BasePresenter;
import com.keno.architecture.pojo.WeatherEntity;

/****
 * Description: 
 * Author:  keno
 * CreateDate: 2020/11/30 22:06
 */

public class WeatherPresent extends BasePresenter<WeatherActivity, WeatherModel, WeatherContract.Presenter<WeatherEntity>> {
    @Override
    public WeatherContract.Presenter<WeatherEntity> getContract() {
        //纪要执行View的指令，又要分配工作给Model去完成这个需求
        return new WeatherContract.Presenter<WeatherEntity>() {
            @Override
            public void requestWeather() {
                //三种风格 第一种，P层只做转发
                model.getContract().requestWeather();

                //第二种，P层也可以做很多事,完成Model的工作
//                responseResult();

                //第三种、让功能模块去工作（muldle下载、请求、图片加载等等）


            }

            @Override
            public void responseResult(WeatherEntity entity) {
                //通知View层 结果
                getView().getContract().hanleResult(entity);
            }
        };
    }

    @Override
    public WeatherModel getModel() {
        return new WeatherModel(this);
    }
}
