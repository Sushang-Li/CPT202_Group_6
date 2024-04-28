package com.group6.booking4sportcentre.service;

import com.group6.booking4sportcentre.mapper.WalletInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class WalletService {

    @Autowired
    private WalletInfoMapper walletInfoMapper;

    //
    public void reduceBookingCost(Long walletInfoId, Double bookingCost) {
        walletInfoMapper.updateWalletBalance(walletInfoId, bookingCost);
    }

    public double getWalletBalance(Long walletInfoId) {
        return walletInfoMapper.getWalletBalance(walletInfoId);
    }

}