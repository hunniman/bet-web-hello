package com.bet.domain.emumclass;

/**
 * Created by pengweiyuan on 4/2/16.
 */
public enum UserStatus {
   ENABLE("可用"),DISABLE("禁用");
   UserStatus(String text){
       this.text=text;
   }
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
