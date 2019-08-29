package com.keno.architecture.binding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.keno.architecture.R;
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
            StringBuffer sb = new StringBuffer();
            Random random = new Random();
            int length = random.nextInt(10) + 10;
            for (int i = 0; i < length; i++) {
                long result = Math.round(Math.random() * 25 + 97);
                sb.append(String.valueOf((char) result));
            }
            UserInfo userInfo = new UserInfo(sb.toString(), length);
            binding.setUser(userInfo);
        }
    }
}
