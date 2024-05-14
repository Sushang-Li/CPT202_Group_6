package com.group6.booking4sportcentre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.group6.booking4sportcentre.mapper.UserInfoMapper;
import com.group6.booking4sportcentre.model.UserInfo;


@RestController
@CrossOrigin
public class UserInfoController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    //用户更新自己的数据,接收前端传过来的用户id以及更改后的数据，把这次更新传递到数据库
    @PostMapping("/api/user/updateInfo")
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
    @GetMapping("/api/user/information")
    public UserInfo getUserInfo(@RequestParam(value = "id", required = false) int id) {
        UserInfo userInfo = (UserInfo) userInfoMapper.selectById(id);
        return userInfo;
    }


    
}
