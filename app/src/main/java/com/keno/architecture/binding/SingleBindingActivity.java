package com.keno.architecture.binding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.keno.architecture.R;
import com.keno.architecture.databinding.ActivitySingleBindingBinding;

public class SingleBindingActivity extends AppCompatActivity {
    private ActivitySingleBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_single_binding);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_binding);


    }


}
