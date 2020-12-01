package com.keno.architecture.base;


/**** 
 * Description: 
 * Author:  keno
 * CreateDate: 2020/11/30 21:41
 */
public abstract class BaseModel<P extends BasePresenter, CONTRACT> {
    protected P present;

    public BaseModel(P present) {
        this.present = present;
    }

    public abstract CONTRACT getContract();
}
