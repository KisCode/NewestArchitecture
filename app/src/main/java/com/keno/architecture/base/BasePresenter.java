package com.keno.architecture.base;


import java.lang.ref.WeakReference;

/****
 * Description: 
 * Author:  keno
 * CreateDate: 2020/11/30 21:50
 */

public abstract class BasePresenter<V extends BaseView, M extends BaseModel, CONTRACT> {
    protected M model;
    private WeakReference<V> vWeakReference;

    public void bindView(V view) {
        vWeakReference = new WeakReference<>(view);
    }

    public void unBindView() {
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference = null;
            System.gc();
        }
    }

    public V getView() {
        if (vWeakReference != null) {
            return vWeakReference.get();
        }
        return null;
    }

    //获取子类具体契约（Model和View协商的共同业务）
    public abstract CONTRACT getContract();

    public abstract M getModel();
}
