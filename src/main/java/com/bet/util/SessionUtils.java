package com.bet.util;



import com.bet.common.SimpleUser;

import javax.servlet.http.HttpSession;

/**
 * Created by pengweiyuan on 1/1/17.
 */
public class SessionUtils {

    public static final String SESSION_ATTRI_USER = "user";

    public static SimpleUser getCurrentUser(HttpSession httpSession) {
        Object attribute = httpSession.getAttribute(SESSION_ATTRI_USER);
        if (attribute == null) return null;
        SimpleUser user = (SimpleUser) attribute;
        return user;
    }

    public static void setCurrentUser(HttpSession httpSession, SimpleUser user) {
        httpSession.setAttribute(SESSION_ATTRI_USER, user);
    }

    public static void clearData(HttpSession httpSession) {
        httpSession.removeAttribute(SESSION_ATTRI_USER);
    }
}
