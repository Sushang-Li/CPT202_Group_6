package com.group6.booking4sportcentre.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * @author Fuyu.Xing
 * @create 2024-04-23 17:33
 */
@Entity
@TableName("coupon_info")
@Data
public class CouponInfo {
    @Id
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int faceValue;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    // CouponStatus: Used, Unused, Expired
    @Enumerated(EnumType.STRING)
    private CouponStatus status;

}
