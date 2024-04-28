package com.group6.booking4sportcentre.controller;
import com.group6.booking4sportcentre.model.WalletInfo;
import com.group6.booking4sportcentre.service.WalletService;
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
    private WalletService walletService;

    @Autowired
    private WalletInfoMapper WalletInfoMapper;

   @PostMapping
    public Long createWallet(@RequestBody WalletInfo walletInfo) {
        WalletInfoMapper.createWalletInfo(walletInfo);
        return walletInfo.getId();
    }

    //get wallet balance
    @GetMapping("/api/wallet")
    public double getWalletBalance(@RequestParam Long walletInfoId) {
        return walletService.getWalletBalance(walletInfoId);
    }




}