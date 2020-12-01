package com.keno.architecture.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.keno.architecture.R;
import com.keno.architecture.base.BaseEntity;
import com.keno.architecture.base.BaseView;
import com.keno.architecture.pojo.Weather;
import com.keno.architecture.pojo.WeatherEntity;

public class WeatherActivity extends BaseView<WeatherPresent, WeatherContract.View<WeatherEntity>> implements View.OnClickListener {
    Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        btnRequest = findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(this);
    }

    @Override
    public WeatherContract.View<WeatherEntity> getContract() {
        return new WeatherContract.View<WeatherEntity>() {
            @Override
            public void hanleResult(WeatherEntity weatherEntity) {
                Toast.makeText(WeatherActivity.this, weatherEntity.getMsg(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public WeatherPresent getPresenter() {
        return new WeatherPresent();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRequest) {
            present.getContract().requestWeather();
        }
    }
}