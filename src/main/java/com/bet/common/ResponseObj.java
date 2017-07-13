package com.bet.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by pengweiyuan on 07/06/2017.
 */
public class ResponseObj implements Serializable {

    @JsonProperty("code")
    private int code;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("data")
    private Object data;


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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseObj buildSuccess(Object value) {
        ResponseObj responseObj = new ResponseObj();
        responseObj.setCode(ResponseEnum.SUCCRSS.getStatus());
        responseObj.setMsg(ResponseEnum.SUCCRSS.getDesc());
        responseObj.setData(value);
        return responseObj;
    }


    public static ResponseObj buildSuccess() {
        ResponseObj responseObj = new ResponseObj();
        responseObj.setCode(ResponseEnum.SUCCRSS.getStatus());
        responseObj.setMsg(ResponseEnum.SUCCRSS.getDesc());
        return responseObj;
    }

    public static ResponseObj buildError(Object value) {
        ResponseObj responseObj = new ResponseObj();
        responseObj.setCode(ResponseEnum.ERROR.getStatus());
        responseObj.setMsg(value.toString());
        return responseObj;
    }

    public static ResponseObj buildError(ResponseEnum responseEnum) {
        ResponseObj responseObj = new ResponseObj();
        responseObj.setCode(responseEnum.getStatus());
        responseObj.setMsg(responseEnum.getDesc());
        return responseObj;
    }




}
