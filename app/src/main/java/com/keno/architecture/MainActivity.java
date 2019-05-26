package com.keno.architecture;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.keno.architecture.databinding.ActivityMainBinding;
import com.keno.architecture.pojo.ObservableUser;
import com.keno.architecture.pojo.UserInfo;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private UserInfo userInfo;
    private ObservableUser observableUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        final ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());  //初始化方式二
//        randomName(binding);

        userInfo = new UserInfo("NormalUser", 23);
        binding.setUser(userInfo);

        binding.setHandlers(new MyEventHandler()); //实例进行绑定
        binding.setPresenter(new Presenter());  //监听绑定

        observableUser = new ObservableUser("Mike", "Jordan");
        //绑定Observal对象
        binding.setObsUser(observableUser);
    }

    private void randomName(final ActivityMainBinding binding) {
        //定时任务生产随机数，动态更新UI
        final Random random = new Random();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int age = random.nextInt(99);
                String name = "User age " + age;
                binding.setUser(new UserInfo(name, age));
                handler.postDelayed(this, 800);
            }
        }, 1000);
    }

    private Handler handler = new Handler();

    public class MyEventHandler {
        public void onClickButton(View view) {
            Toast.makeText(MainActivity.this, "onClickButton", Toast.LENGTH_LONG).show();
        }

        public boolean onLongClickButton(View view) {
            Toast.makeText(MainActivity.this, "onLongClickButton", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public class Presenter {
        public void onPrintUserInfo(UserInfo userInfo) {
            String info = userInfo.getUserName() + "_" + userInfo.getAge();
            Toast.makeText(MainActivity.this, info, Toast.LENGTH_LONG).show();
            Log.i("userInfo", info);
            //由于userInfo是普通对象，未继承BaseObserval,当UserName修改后，UI显示不会改变
            userInfo.setUserName("New NormalUser");
        }

        public void updateFirstName() {
            String firstName = "Mike_" + Calendar.getInstance().get(Calendar.MILLISECOND);
            observableUser.setFirstName(firstName);
        }

        public void updateLastName() {
            String lastName = "LastName_" + Calendar.getInstance().get(Calendar.MILLISECOND);
            observableUser.setLastName(lastName);
        }
    }
}
