package com.group6.booking4sportcentre.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import com.group6.booking4sportcentre.model.CouponInfo;
import com.group6.booking4sportcentre.model.CouponStatus;
import com.group6.booking4sportcentre.mapper.CouponInfoMapper;
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
    public String addCoupon(@RequestBody CouponInfo couponInfo) {
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

    @Transactional
    @GetMapping("/api/coupons/user/{userId}")
    public ResponseEntity<List<CouponInfo>> getCouponsByUser(@PathVariable Long userId) {
        List<CouponInfo> coupons = couponInfoMapper.selectByUserIdAndStatus(userId,"ACTIVE");
        if (coupons.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(coupons);
    }

    //查了好久bug发现是大小写的问题......
    @Transactional
    @PostMapping("/api/coupons/use/{id}")
    public ResponseEntity<String> useCoupon(@PathVariable Long id, @RequestBody Map<String, Double> payload) {
        double bookingCost = payload.get("bookingCost");

        CouponInfo coupon = couponInfoMapper.selectById(id);
        if (coupon == null) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"Coupon not found.\"}");
        }

        String trimmedStatus = coupon.getStatus().name().trim();

        if (trimmedStatus.equals("ACTIVE")) {
        } else {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"Invalid or inactive coupon.\"}");
        }

        if (!coupon.getStatus().name().equalsIgnoreCase("ACTIVE")) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"Invalid or inactive coupon.\"}");
        }

        double newFaceValue = coupon.getFaceValue() - bookingCost;

        if (newFaceValue < 0) {
            return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"Insufficient coupon balance, please use another coupon.\"}");
        }

        if (newFaceValue == 0) {
            coupon.setFaceValue(0);
            coupon.setStatus(CouponStatus.EXPIRED);
        } else {
            coupon.setFaceValue((int) newFaceValue);
        }

        couponInfoMapper.updateById(coupon);
        return ResponseEntity.ok("{\"success\": true, \"message\": \"Coupon applied successfully.\"}");
    }





}