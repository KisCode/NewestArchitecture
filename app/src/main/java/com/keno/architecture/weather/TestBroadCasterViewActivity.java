package com.keno.architecture.weather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.keno.architecture.R;
import com.keno.architecture.StringUtlis;

public class TestBroadCasterViewActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ACTION_TEST = "action_test";
    private static final String KEY_STRING = "STRING";

    private TextView tvContent;
    private Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);
        initView();
//        Button btnRefresh = findViewById(R.id.btn_refresh);
//        btnRefresh.setText("kkkkkk");
//        btnRefresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        IntentFilter intentFilterLocal = new IntentFilter();
        intentFilterLocal.addAction(ACTION_TEST);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, intentFilterLocal);

        //注册广播监听器
        IntentFilter netReceiverFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//        LocalBroadcastManager.getInstance(this).registerReceiver(netReceiver, netReceiverFilter);
        registerReceiver(netReceiver, netReceiverFilter);
    }

    private void initView() {
        tvContent = (TextView) findViewById(R.id.tv_content);
        btnRefresh = (Button) findViewById(R.id.btn_refresh);

        btnRefresh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_refresh:
                String randomStr = StringUtlis.getRandomeStr();

                tvContent.setText(randomStr);
                Intent intent = new Intent(ACTION_TEST);
                intent.putExtra(KEY_STRING, randomStr);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);

        LocalBroadcastManager.getInstance(this).unregisterReceiver(netReceiver);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String receiveStr = intent.getStringExtra(KEY_STRING);
            Log.i("onReceive", intent.getAction() + "__" + receiveStr);
        }
    };

    private BroadcastReceiver netReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                Log.i("onReceiveNet", "网络状态改变了");
            }
        }
    };
}
