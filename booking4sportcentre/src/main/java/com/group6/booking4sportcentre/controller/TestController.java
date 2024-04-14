package com.group6.booking4sportcentre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group6.booking4sportcentre.model.Test;
import com.group6.booking4sportcentre.repository.TestRepo;


@RestController
public class TestController {
    @Autowired
    private TestRepo testRepo;
//    尝试添加mybatis-plus用法，但是失败了
//    @Autowired
//    private TestMapper testMapper;
//    @GetMapping("/api/test4Mapper")
//    public List queryTest() {
//        List<Test> testList = testMapper.selectList(null);
//        System.out.println("testList = " + testList);
//        return testList;
//    }

    @GetMapping("/api/test")
    public List<Test> getTest() {
        return testRepo.findAll();
    }
}
