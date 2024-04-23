package com.group6.booking4sportcentre.controller;


import com.group6.booking4sportcentre.mapper.CouponInfoMapper;
import com.group6.booking4sportcentre.model.CouponInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fuyu.Xing
 * @create 2024-04-23 17:29
 */

@RestController
public class CouponController {
    @Autowired
    private CouponInfoMapper couponInfoMapper;

    //get all coupons
//If there is no coupon information, return empty list
    @GetMapping("/api/coupons")
    public List<CouponInfo> viewCoupons() {
        return couponInfoMapper.selectList(null);
    }


    //get coupon by name
    //If the name does not exist, return null
    @GetMapping("/api/get_coupon_by_name")
    public CouponInfo getCouponByName(@RequestParam String name) {
        return couponInfoMapper.selectByName(name);
    }

    //add coupon
    @PostMapping("/api/add_coupon")
    public String addCoupon(CouponInfo couponInfo) {
        int i = couponInfoMapper.insert(couponInfo);
        if (i == 0) {
            return "Add coupon information failed";
        }
        return "Add coupon information successfully";
    }

    //update coupon
    @PostMapping("/api/update_coupon")
    public String updateCoupon(CouponInfo couponInfo) {
        int i = couponInfoMapper.updateById(couponInfo);
        if (i == 0) {
            return "Update coupon information failed";
        }
        return "Update coupon information successfully";
    }

    //delete coupon
    @PostMapping("/api/delete_coupon")
    public String deleteCoupon(@RequestParam Long id) {
        int i = couponInfoMapper.deleteById(id);
        if (i == 0) {
            return "Delete coupon information failed";
        }
        return "Delete coupon information successfully";
    }

    //get coupon by status
    @GetMapping("/api/get_coupon_by_status")
    public List<CouponInfo> getCouponByStatus(@RequestParam String status) {
        return couponInfoMapper.selectByStatus(status);
    }



}