package com.keno.architecture.base;


/**** 
 * Description: 
 * Author:  keno
 * CreateDate: 2020/11/30 21:47
 */

public class BaseEntity {
    protected int code;
    protected String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
