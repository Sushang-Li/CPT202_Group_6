package com.group6.booking4sportcentre.controller;
import com.group6.booking4sportcentre.model.WalletInfo;
import com.group6.booking4sportcentre.mapper.WalletInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Fuyu.Xing
 * @create 2024-04-28 21:00
 */

@RestController
public class WalletController {


    @Autowired
    private WalletInfoMapper walletInfoMapper;

   @PostMapping
    public Long createWallet(@RequestBody WalletInfo walletInfo) {
        walletInfoMapper.createWalletInfo(walletInfo);
        return walletInfo.getId();
    }

    //get wallet balance
    @GetMapping("/api/wallet")
    public double getWalletBalance(@RequestParam Long walletInfoId) {
        return walletInfoMapper.getWalletBalance(walletInfoId);
    }

    @PostMapping("/api/wallet/reduce")
    public void reduceBookingCost(@RequestParam Long walletInfoId, @RequestParam Double bookingCost) {
        walletInfoMapper.updateWalletBalance(walletInfoId, bookingCost);
    }


}