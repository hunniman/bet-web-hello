package com.bet.controller;


import com.bet.common.ResponseObj;
import com.bet.common.SimpleUser;
import com.bet.domain.UserInfo;
import com.bet.domain.emumclass.Role;
import com.bet.repository.UserRepository;
import com.bet.repository.impl.UserRepositoryImpl;
import com.bet.util.SessionUtils;
import com.bet.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by pengweiyuan on 07/06/2017.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private UserRepositoryImpl userRepoImpl;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/show_login", method = RequestMethod.GET)
    public String showLogin() {
        return "/user/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpSession httpSession) {
        SessionUtils.clearData(httpSession);
        return "/user/login";
    }


    @RequestMapping(value = "/show_register", method = RequestMethod.GET)
    public String showRegister() {
        return "/user/register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObj register(@RequestBody HashMap<String, String> userInfo, HttpSession httpSession) {

        ResponseObj responseObj = null;

        String username = userInfo.get("username");
        String password = userInfo.get("password");
        String mobile = userInfo.get("mobile");
        String realName = userInfo.get("realName");

        if (StringUtils.isEmpty(username)) {
            responseObj = ResponseObj.buildError("请填写用户名");
            return responseObj;
        }

        if (StringUtils.isEmpty(password)) {
            responseObj = ResponseObj.buildError("请填写密码");
            return responseObj;
        }

        if (StringUtils.isEmpty(mobile)) {
            responseObj = ResponseObj.buildError("请填写手机号码");
            return responseObj;
        }

        if (StringUtils.isEmpty(realName)) {
            responseObj = ResponseObj.buildError("请填写真实姓名");
            return responseObj;
        }


        UserInfo user = new UserInfo();
        user.setMobile(mobile);
        user.setUsername(username);
        user.setRealName(realName);
        user.setRole(Role.NORMAL.getType());
        user.setCreateAt(new Date());
        long timeStamp = System.currentTimeMillis();
        user.setPasswordTimestamp(timeStamp);

        String md5Password = userUtil.getMd5Password(timeStamp, password);
        user.setPassword(md5Password);

        userRepository.save(user);

        responseObj = ResponseObj.buildSuccess(user.getId());
        return responseObj;
    }


    @RequestMapping(value = "/all_user", method = RequestMethod.GET)
    public ModelAndView allUser(HttpSession httpSession) {

        java.util.List<UserInfo> userInfoList = userRepoImpl.findAllAndOrder();
        //java.util.List<UserInfo> userInfoList = userRepository.findAllOrderByCreateTime();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user_info", userInfoList);
        modelAndView.setViewName("/user/userList");
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObj login(@RequestBody HashMap<String, String> userInfo, HttpSession httpSession) {
        String userName = userInfo.get("username");
        String password = userInfo.get("password");

        UserInfo user = userRepository.findByUsername(userName);
        if (user == null) {
            return ResponseObj.buildError("用户不存在");
        }
        Long timestamp = user.getPasswordTimestamp();
        String md5Password = userUtil.getMd5Password(timestamp, password);
        if (!org.apache.commons.lang3.StringUtils.equals(md5Password, user.getPassword())) {
            return ResponseObj.buildError("密码不正确");
        }
        SimpleUser simpleUser = SimpleUser.build(user);
        SessionUtils.setCurrentUser(httpSession, simpleUser);
        return ResponseObj.buildSuccess();
    }
}