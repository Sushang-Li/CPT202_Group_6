package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.UserInfoMapper;
import com.group6.booking4sportcentre.model.UserInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserLoginController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @PostMapping("/stuLogin")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        System.out.println("login");
        // 调用UserInfoMapper进行验证
        UserInfo user = userInfoMapper.selectByUsernameAndPassword(username, password);
        if (user != null) {
            // 登录成功，将用户信息存储到Session中
            session.setAttribute("user", user);

            //得到登录用户的ID
            UserInfo userInfo = (UserInfo) session.getAttribute("user");
            Integer userId = userInfo.getId();

            //把用户ID传给前端用于增删改查，前端从后端获取ID的唯一方式，之后ID在前端页面间相互传递
            return "redirect:/userHomepage.html" + "?id=" + userId; // 登录成功后跳转到用户首页
        } else {
            return "redirect:/userLogin.html?error"; // 登录失败，重定向到登录页面并显示错误消息
        }
    }
}
