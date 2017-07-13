package com.bet.domain;

import com.bet.domain.emumclass.UserStatus;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by pengweiyuan on 4/2/16.
 */
@Entity
@Table(name = "userInfo")
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public class UserInfo extends IDEntity {

    @Column(columnDefinition = "varchar (100) comment '账号' ", unique = true)
    private String username;
    @Column(columnDefinition = "varchar (100) comment '密码' ")
    private String password;
    @Column(columnDefinition = "bigint comment '用于跟密码加密的一个动态字符串(时间戳)'")
    private Long passwordTimestamp;
    @Column(columnDefinition = "varchar (11) comment '手机号码' ")
    private String mobile;
    @Column(columnDefinition = "varchar (50) comment '真实姓名' ")
    private String realName;
    @Column(columnDefinition = "varchar (50) comment '用户状态(启用:ENABLE,禁用:DISABLE)' ")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(columnDefinition = "int comment '角色 0:普通;1:管理员' ")
    private int role;

    //错误提示
    public static final String password_error = "密码错误";
    public static final String username_is_not_null = "用户名不能为空";
    public static final String username_is_exist = "用户名已存在";
    public static final String username_is_not_exist = "用户名不存在";
    public static final String password_is_not_null = "密码不能为空";

    // 密码 md5 加密的key
    public static final String ssoPasswordEncodeKey = "xc??vn()&^i@!#Y*!&@Tkl~~deh#*!ut@#!$ks√fhs213@1234vx>>>..';[]5938˜∫√ƒ45$@#&$T@&#$^!@#!*#$^*!^#*&^<>M";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Long getPasswordTimestamp() {
        return passwordTimestamp;
    }

    public void setPasswordTimestamp(Long passwordTimestamp) {
        this.passwordTimestamp = passwordTimestamp;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
