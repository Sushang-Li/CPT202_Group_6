package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.UserInfoMapper;
import com.group6.booking4sportcentre.model.Message;
import com.group6.booking4sportcentre.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yixuan.Wang
 * @create 2024-04-28 20:24
 */
@RestController
public class AdminUserInfoController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    //View all user registration information
    //@GetMapping("/api/UserInfo")
    //@Transactional
    //public List<UserInfo> findAll() {
    //return userInfoMapper.findAll();
    //}

    // 分页查询用户信息（替换原来的 findAll()）
    @GetMapping("/api/UserInfo")
    @Transactional
    public Message getUserInfoByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {

        int offset = (pageNum - 1) * pageSize;
        List<UserInfo> users = userInfoMapper.findByPage(offset, pageSize);
        int total = userInfoMapper.selectTotalCount();

        Message mes = new Message();
        mes.message = "查询成功";
        mes.objects = users;
        mes.total = total; // 确保 Message 类有 total 字段
        return mes;
    }

    //View user registration by id
    @GetMapping("/api/getUserById/{id}")
    @Transactional
    public UserInfo findById(@PathVariable Integer id){
        return userInfoMapper.selectById(id);
    }

    //Add user registration information
    @PostMapping("/api/addUser")
    public Message addUser(UserInfo userInfo){
        int add = userInfoMapper.insert(userInfo);
        //Message returned during verification
        Message mes = new Message();
        mes.message = "Added successfully!";
        //Return the added information
        mes.objects =userInfoMapper.findAll();
        return mes;

    }


    //Update user registration information
    @Transactional
    @PostMapping("/api/updateUser")
    public Message updateUser(UserInfo userInfo) {
        int i = userInfoMapper.updateById(userInfo);
        if (i == 0) {
            //Message returned during verification
            Message mes = new Message();
            mes.message = "Update failed!";
        }
        Message mes = new Message();
        mes.message = "Update successful!";
        //Return the updated information
        mes.objects = userInfoMapper.findAll();
        return mes;
    }



    //Delete user registration information
    @Transactional
    @DeleteMapping("/api/deleteUser")
    public Message deleteUser(Integer id) {
        int i = userInfoMapper.deleteById(id);
        if (i == 0){
            //Message returned during verification
            Message mes = new Message();
            mes.message = "Delete failed!";
            return mes;
        }
        else {
            Message mes = new Message();
            mes.message = "Delete successful!";
            //Return the deleted information
            mes.objects = userInfoMapper.findAll();
            return mes;
        }


    }
}
