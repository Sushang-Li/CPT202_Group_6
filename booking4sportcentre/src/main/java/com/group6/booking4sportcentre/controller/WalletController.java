package com.group6.booking4sportcentre.controller;
import com.group6.booking4sportcentre.model.WalletInfo;
import com.group6.booking4sportcentre.mapper.WalletInfoMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fuyu.Xing
 * @create 2024-04-28 21:00
 */

@RestController
@RequestMapping("/api/wallet")
public class WalletController {


    @Autowired
    private WalletInfoMapper walletInfoMapper;


    //create wallet
   @PostMapping
    public Long createWallet(@RequestBody WalletInfo walletInfo) {
        walletInfoMapper.createWalletInfo(walletInfo);
        return walletInfo.getId();
    }

    //get wallet balance
    @GetMapping("/{walletInfoId}")
    public ResponseEntity<Double> getWalletBalance(@PathVariable Long walletInfoId) {
        try {
            double balance = walletInfoMapper.getWalletBalance(walletInfoId);
            return ResponseEntity.ok(balance);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // Pay with wallet
    @PostMapping("/pay")
    public ResponseEntity<?> payWithWallet(@RequestParam Long walletInfoId, @RequestParam Double bookingCost) {
        try {
            double currentBalance = walletInfoMapper.getWalletBalance(walletInfoId);
            if (currentBalance >= bookingCost) {
                double newBalance = currentBalance - bookingCost;
                walletInfoMapper.updateWalletBalance(walletInfoId, newBalance);
                double updatedBalance = walletInfoMapper.getWalletBalance(walletInfoId);
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

  /*  @GetMapping("/info")
    public WalletInfo getWallet(HttpSession session) {
        // 从Session中获取钱包信息
        WalletInfo wallet = (WalletInfo) session.getAttribute("wallet");
        return wallet;
    }*/

    @GetMapping("/balance/{userId}")
    public ResponseEntity<?> getWallet(@PathVariable int userId) {
        try {
            double balance = walletInfoMapper.selectBalanceByUserId(userId);

                return ResponseEntity.ok(balance);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get wallet");
        }
    }



    @PostMapping("/recharge")
    public ResponseEntity<?> rechargeWallet(@RequestBody Map<String, Integer> payload) {
        int userId = payload.get("userId");
        final double RECHARGE_AMOUNT = 100.0; // Fixed recharge amount

        try {
            // Fetch current balance, update it, and save the new balance
            double currentBalance = walletInfoMapper.selectBalanceByUserId(userId);
            double newBalance = currentBalance + RECHARGE_AMOUNT;
            walletInfoMapper.updateWalletBalanceByUserId(userId, newBalance);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Recharge successful");
            response.put("newBalance", newBalance);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to recharge wallet");
        }
    }
}





