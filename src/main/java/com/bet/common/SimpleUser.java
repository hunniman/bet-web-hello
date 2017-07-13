package com.bet.common;

import com.bet.domain.UserInfo;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * Created by pengweiyuan on 16/06/2017.
 */
public class SimpleUser implements Serializable {

    private long id;

    private String mobile;

    private String realName;

    private int role;

    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public static SimpleUser build(UserInfo userInfo) {
        SimpleUser simpleUser = new SimpleUser();
        BeanUtils.copyProperties(userInfo, simpleUser);
        return simpleUser;
    }
}
