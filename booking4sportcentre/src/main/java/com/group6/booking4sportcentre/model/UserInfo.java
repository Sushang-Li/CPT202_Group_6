package com.group6.booking4sportcentre.model;


import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@TableName("user_info")
@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    @Column(name = "phone_num")
    private String phoneNum;
    private String intro;
    @Column(name = "re_date")
    private LocalDate reDate;
}
