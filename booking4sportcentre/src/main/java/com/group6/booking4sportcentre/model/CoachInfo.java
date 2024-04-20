package com.group6.booking4sportcentre.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

/**
 * @author Mingyuan.Li
 * @create 2024-04-20 15:08
 */
@Entity
@TableName("coach_info")
@Data
public class CoachInfo {
    @Id
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String contact;
    private LocalTime startTime;
    private LocalTime endTime;
    // CoatStatus: WORKING, IDLE, OFF
    @Enumerated(EnumType.STRING)
    private CoachStatus status;
    // Maybe need join query
    private String activity;
}
