package com.bet.util;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * Created by pengweiyuan on 12/19/16.
 */
@Component
public class UserUtil {

    /**
     * 通过明文的密码，获取md5后的密码
     *
     * @param lawsPassword
     * @return
     */
    public String getMd5Password(long passwordTimeStamp, String lawsPassword) {
        return DigestUtils.md5Hex(passwordTimeStamp + lawsPassword);
    }

    /**
     * 获取accessToken
     * 生成规则是 userId + username + password + timestamp 然后md5
     *
     * @param userId
     * @param username
     * @param password
     * @param timestamp
     * @return
     */
    public String getMd5AccessToken(Long userId, String username, String password, Long timestamp) {
        return DigestUtils.md5Hex(userId + username + password + timestamp);
    }

}
