package com.group6.booking4sportcentre.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.group6.booking4sportcentre.mapper.UserInfoMapper;
import com.group6.booking4sportcentre.model.UserInfo;

import java.time.LocalDate;
import java.util.List;

@Controller
//@RestController
@CrossOrigin
public class UserInfoController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    
    //插入测试数据，temp
    @PostMapping("/user/insertTestData")
    public void insertTestData(@RequestBody List<UserInfo> list) {
        for (UserInfo userInfo : list) {
            userInfoMapper.insert(userInfo);
        }
    }

    //用户更新自己的数据,接收前端传过来的用户id以及更改后的数据，把这次更新传递到数据库
    @PostMapping("/user/updateInfo")
    public void updateInfo(@RequestParam int userId, @RequestParam String username, @RequestParam String password,
                           @RequestParam String phoneNumber, @RequestParam String signature) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setPhoneNum(phoneNumber);
        userInfo.setIntro(signature);

        userInfoMapper.updateById(userInfo);

    }


    //读取id=1的用户信息
    //https://localhost:8080/user/information?id=1
    @GetMapping("/user/information")
    public UserInfo getUserInfo(@RequestParam(value = "id", required = false) int id) {
        UserInfo userInfo = (UserInfo) userInfoMapper.selectById(id);
        return userInfo;
    }



    @GetMapping("/api/user_test")
    public UserInfo getUser(@RequestParam(value = "id", required = false) int param) {
        UserInfo userInfo = (UserInfo) userInfoMapper.selectById(param);
        return userInfo;
    }

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
            return "redirect:/userHomepage.html"; // 登录成功后跳转到用户首页
        } else {
            return "redirect:/userLogin.html?error"; // 登录失败，重定向到登录页面并显示错误消息
        }
    }
    
}
