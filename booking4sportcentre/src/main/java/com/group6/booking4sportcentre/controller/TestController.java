package com.group6.booking4sportcentre.controller;

import java.util.List;

import com.group6.booking4sportcentre.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group6.booking4sportcentre.model.Test;
//import com.group6.booking4sportcentre.repository.TestRepo;


@RestController
public class TestController {
//    @Autowired
//    private TestRepo testRepo;
//
//    @GetMapping("/api/test")
//    public List<Test> getTest() {
//        return testRepo.findAll();
//    }

//  mybatis-plus用法：
    @Autowired
    private TestMapper testMapper;
    @GetMapping("/api/testMapper")
    public List queryTest() {
//        添加测试
//        Test test = new Test();
//        test.setId(9);
//        testMapper.insert(test);
//        查询测试：
        List<Test> testList = testMapper.selectList(null);
        System.out.println("testList = " + testList);
        System.out.println("查询成功！");
        return testList;
    }
}
