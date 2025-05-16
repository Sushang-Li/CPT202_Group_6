package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.AdminInfoMapper;
import com.group6.booking4sportcentre.model.AdminInfo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Mingyuan.Li
 * @create 2024-04-19 19:25
 */
@Controller
@RequiredArgsConstructor
public class AdminLoginController {

    private final AdminInfoMapper adminInfoMapper;

    //    管理员登录：数据库中已存有管理员信息，通过用户名和密码进行登录验证
//    Administrator login: The database has stored the administrator information,
//    through the username and password login verification
    @PostMapping("/api/adminlogin")
    public String adminLogin(@RequestParam String username, @RequestParam String password) {
        // Get all administrator information
        List<AdminInfo> admins = adminInfoMapper.selectList(null);
        // Authenticate the username and password:
        for (AdminInfo admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return "Login successfully!";
            }
        }
        return "Wrong username or password!";
    }

    @PostMapping("/admLogin")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        System.out.println("login");
        // 调用UserInfoMapper进行验证
        AdminInfo user = adminInfoMapper.selectByUsernameAndPassword(username, password);
        if (user != null) {
            // 登录成功，将用户信息存储到Session中
            session.setAttribute("user", user);
            return "redirect:/adminHomePage.html"; // 登录成功后跳转到用户首页
        } else {
            return "redirect:/adminLogin.html?error"; // 登录失败，重定向到登录页面并显示错误消息
        }
    }
}
