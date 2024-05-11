package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.UserInfoMapper;
import com.group6.booking4sportcentre.mapper.WalletInfoMapper;
import com.group6.booking4sportcentre.model.UserInfo;
import com.group6.booking4sportcentre.model.WalletInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private WalletInfoMapper walletInfoMapper;

    @PostMapping("/register")
    public String register(@RequestParam("stuId") Integer stuId,
                           @RequestParam("email") String email,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("dob") String dob, // 前端传递的可能是字符串
                           @RequestParam("address") String address,
                           @RequestParam("gender") Integer gender,
                           @RequestParam("password") String password,
                           @RequestParam("phoneNum") String phoneNum,
                           RedirectAttributes redirectAttributes) {

        UserInfo userInfo = new UserInfo();
        userInfo.setStuId(stuId);
        userInfo.setEmail(email);
        userInfo.setPassword(password);
        userInfo.setFirstName(firstName);
        userInfo.setLastName(lastName);
        userInfo.setDob(LocalDate.parse(dob)); // 将字符串解析为LocalDate
        userInfo.setPhoneNum(phoneNum);
        userInfo.setAddress(address);
        userInfo.setGender(gender);

        userInfoMapper.insert(userInfo); // 使用MyBatis Plus的insert方法

        // 创建钱包
        WalletInfo walletInfo = new WalletInfo();
        walletInfo.setUserId(userInfo.getId());
        walletInfo.setBalance(0.0);
        walletInfoMapper.createWalletInfo(walletInfo);

        redirectAttributes.addFlashAttribute("message", "注册成功！");
        return "redirect:/userLogin.html"; // 假设有一个登陆页面
    }
}

