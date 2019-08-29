package com.keno.architecture.binding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.keno.architecture.R;
import com.keno.architecture.StringUtlis;
import com.keno.architecture.databinding.ActivityBindUserBinding;
import com.keno.architecture.pojo.UserInfo;

import java.util.Random;

public class BindUserActivity extends AppCompatActivity {
    ActivityBindUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_binding);
        //databinding 初始化
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bind_user);

        //监听绑定
        binding.setEventPresenter(new EventPresenter());

        binding.setUser(new UserInfo("Kobe ", 39));
    }


    public static void start(Context context) {
        context.startActivity(new Intent(context, BindUserActivity.class));
    }

    public class EventPresenter {
        public void refrshUser() {
            UserInfo userInfo = new UserInfo(StringUtlis.getRandomeStr(), StringUtlis.getRandomeStr().length());
            binding.setUser(userInfo);
        }
    }
}
