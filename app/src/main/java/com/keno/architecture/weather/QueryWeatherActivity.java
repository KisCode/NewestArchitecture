package com.keno.architecture.weather;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.keno.architecture.R;
import com.keno.architecture.databinding.ActivityQueryWeatherBinding;
import com.keno.architecture.weather.viewmodel.QueryWeatherViewModel;

public class QueryWeatherActivity extends AppCompatActivity {

    private ActivityQueryWeatherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_query_weather);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_query_weather);


        QueryWeatherViewModel queryWeatherViewModel = new QueryWeatherViewModel();

//        ;
        binding.setWeatherViewModel(queryWeatherViewModel);
    }
}
