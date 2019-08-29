package com.keno.architecture.binding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.keno.architecture.R;
import com.keno.architecture.StringUtlis;
import com.keno.architecture.databinding.ActivityDoubleBindingBinding;
import com.keno.architecture.pojo.ObservableUser;

/***
 * 双向数据绑定
 */
public class DoubleBindingActivity extends AppCompatActivity {
    private ActivityDoubleBindingBinding binding;
    private ObservableUser observableUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_double_binding);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_double_binding);
        binding.setEvent(new EventPresenter());
        observableUser = new ObservableUser("", "");
        binding.setUserInfo(observableUser);

    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, DoubleBindingActivity.class));
    }

    public class EventPresenter {
        public void refrshUser() {
            observableUser.setFirstName(StringUtlis.getRandomeStr());
        }
    }
}
