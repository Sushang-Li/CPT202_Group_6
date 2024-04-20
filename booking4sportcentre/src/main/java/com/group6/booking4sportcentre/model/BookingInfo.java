package com.group6.booking4sportcentre.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Fuyu.Xing
 * @create 2024-04-20 21:44
 */
@Setter
@Getter
@Entity
@TableName("booking_info")
public class BookingInfo {
    @Id
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String venue;
    //BookingStatus: PENDING, CONFIRMED, CANCELLED
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    private String name;
    private double price;


}
