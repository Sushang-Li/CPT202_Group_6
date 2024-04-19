package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.AdminInfoMapper;
import com.group6.booking4sportcentre.model.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mingyuan.Li
 * @create 2024-04-19 19:25
 */
@RestController
public class AdminLoginController {
    @Autowired
    private AdminInfoMapper adminInfoMapper;

//    管理员登录：数据库中已存有管理员信息，通过用户名和密码进行登录验证
//    Administrator login: The database has stored the administrator information,
//    through the username and password login verification
    @PostMapping("/api/login")
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
}
