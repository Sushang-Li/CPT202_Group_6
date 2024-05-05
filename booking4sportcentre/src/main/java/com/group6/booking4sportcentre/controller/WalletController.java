package com.group6.booking4sportcentre.controller;
import com.group6.booking4sportcentre.model.WalletInfo;
import com.group6.booking4sportcentre.mapper.WalletInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> payWithWallet(@RequestParam Long walletInfoId, @RequestParam Double bookingCost) {
        try {
            double currentBalance = walletInfoMapper.getWalletBalance(walletInfoId);
            if (currentBalance >= bookingCost) {
                walletInfoMapper.updateWalletBalance(walletInfoId, currentBalance - bookingCost);
                return ResponseEntity.ok("Payment successful");
            } else {
                return ResponseEntity.badRequest().body("Insufficient balance");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment processing failed");
        }
    }


    }
