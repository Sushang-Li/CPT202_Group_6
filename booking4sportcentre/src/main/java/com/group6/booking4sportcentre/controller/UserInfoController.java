package com.group6.booking4sportcentre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group6.booking4sportcentre.mapper.UserInfoMapper;
import com.group6.booking4sportcentre.model.UserInfo;

import java.util.HashMap;
import java.util.Map;


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

    @GetMapping("/api/wallet/balance/{userId}")
    public ResponseEntity<?> getWallet(@PathVariable int userId) {
        try {
            double balance = userInfoMapper.getBalance(userId);

            return ResponseEntity.ok(balance);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get wallet");
        }
    }
    @PostMapping("/api/wallet/pay")
    public ResponseEntity<?> payWithWallet(@RequestParam Integer userId, @RequestParam Double bookingCost) {
        try {
            double currentBalance = userInfoMapper.getBalance(userId);
            if (currentBalance >= bookingCost) {
                double newBalance = currentBalance - bookingCost;
                userInfoMapper.updateBalance(userId, newBalance);
                double updatedBalance = userInfoMapper.getBalance(userId);
                System.out.println(updatedBalance);
                // 使用 Map 创建 JSON 响应
                Map<String, Object> response = new HashMap<>();
                response.put("Payment", "successful");
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body("Insufficient balance");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment processing failed");
        }
    }




    @PostMapping("/api/wallet/recharge")
    public ResponseEntity<?> rechargeWallet(@RequestBody Map<String, Integer> payload) {
        int userId = payload.get("userId");
        final double RECHARGE_AMOUNT = 100.0; // Fixed recharge amount

        try {
            // Fetch current balance, update it, and save the new balance
            double currentBalance = userInfoMapper.getBalance(userId);
            double newBalance = currentBalance + RECHARGE_AMOUNT;
            userInfoMapper.updateBalance(userId, newBalance);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Recharge successful");
            response.put("newBalance", newBalance);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to recharge wallet");
        }
    }
    
}
