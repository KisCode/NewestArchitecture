package com.keno.architecture.binding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.keno.architecture.R;
import com.keno.architecture.StringUtlis;
import com.keno.architecture.databinding.ActivitySingleBindingBinding;
import com.keno.architecture.pojo.ObservableUser;
import com.keno.architecture.pojo.UserInfo;

/**
 * Description: 单项绑定Demo
 * Author: keno
 * CreateDate: 2019/8/29 20:11
 */
public class SingleBindingActivity extends AppCompatActivity {
    private ActivitySingleBindingBinding binding;
    private ObservableUser observableUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_single_binding);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_binding);

        //设置绑定事件
        binding.setEvent(new EventPresenter());

        observableUser = new ObservableUser("单项绑定FirstName", "单项绑定LastName");
        binding.setUserInfo(observableUser);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, SingleBindingActivity.class));
    }

    public class EventPresenter {
        public void refrshUser() {
            observableUser.setFirstName(StringUtlis.getRandomeStr());
            observableUser.setLastName(StringUtlis.getRandomeStr());
        }
    }
}
