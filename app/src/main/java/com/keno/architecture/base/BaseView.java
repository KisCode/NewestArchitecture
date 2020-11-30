package com.keno.architecture.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/****
 * Description: 
 * Author:  keno
 * CreateDate: 2020/11/30 21:53
 */

public abstract class BaseView<P extends BasePresenter, CONTRACT> extends Activity {
    protected P present;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        present = getPresenter();
        present.bindView(this);
    }

    //从子类中获取具体的契约
    public abstract CONTRACT getContract();

    //从子类中获取具体的Presenter
    public abstract P getPresenter();

    //如果Presenter层出现了异常，需要通知View

    @Override
    protected void onDestroy() {
        super.onDestroy();
        present.unBindView();
    }
}
