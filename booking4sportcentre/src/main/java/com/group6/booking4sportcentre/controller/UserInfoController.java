package com.group6.booking4sportcentre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.group6.booking4sportcentre.mapper.UserInfoMapper;
import com.group6.booking4sportcentre.model.UserInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserInfoController {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @GetMapping("/api/user_test")
    public UserInfo getUser(@RequestParam(value = "id", required = false) int param) {
        UserInfo userInfo = userInfoMapper.selectById(param);
        return userInfo;
    }
    
}
