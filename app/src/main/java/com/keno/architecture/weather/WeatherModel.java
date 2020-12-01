package com.keno.architecture.weather;


import com.keno.architecture.base.BaseModel;
import com.keno.architecture.pojo.WeatherEntity;

/****
 * Description: 
 * Author:  keno
 * CreateDate: 2020/11/30 22:05
 */

public class WeatherModel extends BaseModel<WeatherPresent, WeatherContract.Model> {
    public WeatherModel(WeatherPresent present) {
        super(present);
    }

    @Override
    public WeatherContract.Model getContract() {
        return new WeatherContract.Model() {
            @Override
            public void requestWeather() {
                //模拟请求结果返回
                WeatherEntity weatherEntity = new WeatherEntity();
                weatherEntity.setCode(0);
                weatherEntity.setMsg("登录成功！！！");

                present.getContract().responseResult(weatherEntity);
            }
        };
    }
}
