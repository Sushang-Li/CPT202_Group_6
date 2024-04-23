package com.group6.booking4sportcentre;


import com.group6.booking4sportcentre.controller.CouponController;
import com.group6.booking4sportcentre.model.CouponInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Fuyu.Xing
 * @create 2024-04-23 21:50
 */
@SpringBootTest
public class CouponControllerTest {

    @Autowired
    private CouponController couponController;

    @Test
    public void testViewCoupons() {
        // Test the viewCoupons method
        List<CouponInfo> couponInfo = couponController.viewCoupons();
        // Assert that the result is not empty
        assertNotNull(couponInfo);
    }

    @Test
    public void testAddCoupon() {
        // Test the addCoupon method
        CouponInfo couponInfo = new CouponInfo();
        couponInfo.setName("Oct Coupon");
        couponInfo.setFaceValue(100);
        couponInfo.setStartTime(LocalDateTime.parse("2024-04-23T00:00:00"));
        couponInfo.setEndTime(LocalDateTime.parse("2024-04-30T23:59:59"));
        String result = couponController.addCoupon(couponInfo);
        // Assert that the result is not empty
        assertNotNull(result);
    }

    @Test
    public void testGetCouponByName() {
        // Add a coupon named "Oct Coupon"
        CouponInfo newCoupon = new CouponInfo();
        newCoupon.setName("P Coupon");
        newCoupon.setFaceValue(100);
        newCoupon.setStartTime(LocalDateTime.parse("2024-04-23T00:00:00"));
        newCoupon.setEndTime(LocalDateTime.parse("2024-04-30T23:59:59"));
        couponController.addCoupon(newCoupon);

        // Test the getCouponByName method
        CouponInfo couponInfo = couponController.getCouponByName("P Coupon");
        // Assert that the result is not empty
        assertNotNull(couponInfo);
    }



    @Test
    public void testUpdateCoupon() {
        // Test the updateCoupon method
        CouponInfo couponInfo = new CouponInfo();
        couponInfo.setId(1L);
        couponInfo.setName("Sept Coupon");
        couponInfo.setFaceValue(100);
        couponInfo.setStartTime(LocalDateTime.parse("2024-04-23T00:00:00"));
        couponInfo.setEndTime(LocalDateTime.parse("2024-04-30T23:59:59"));
        String result = couponController.updateCoupon(couponInfo);
        // Assert that the result is not empty
        assertNotNull(result);
    }

    @Test
    public void testDeleteCoupon() {
        // Test the deleteCoupon method
        String result = couponController.deleteCoupon(1L);
        // Assert that the result is not empty
        assertNotNull(result);
    }
}
