package com.bet.common;

import java.io.Serializable;

/**
 * Created by pengweiyuan on 07/06/2017.
 */
public enum ResponseEnum implements Serializable {

    SUCCRSS(0, "成功"), ERROR(1, "失败"), NOT_LOGIN(2, "没有登陆");


    private int status;

    private String desc;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ResponseEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }


}
