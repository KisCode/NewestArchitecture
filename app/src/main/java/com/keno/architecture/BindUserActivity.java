package com.keno.architecture;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.keno.architecture.databinding.ActivityBindUserBinding;
import com.keno.architecture.databinding.ActivityMainBinding;
import com.keno.architecture.pojo.UserInfo;

public class BindUserActivity extends AppCompatActivity {
    ActivityBindUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_binding);
        //databinding 初始化
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bind_user);

        binding.setUser(new UserInfo("Kobe ",39));
    }


    public static void start(Context context) {
        context.startActivity(new Intent(context, BindUserActivity.class));
    }

    public class EventHandler{
        public void refrshUser(View view) {
            StringBuffer sb=new StringBuffer();
            long result= Math.round(Math.random()*25+97);
            sb.append(String.valueOf((char)result));
            UserInfo userInfo=new UserInfo(sb.toString(),38);
            binding.setUser(userInfo);
        }
    }
}
