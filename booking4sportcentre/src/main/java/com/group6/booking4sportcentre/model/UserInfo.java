package com.group6.booking4sportcentre.model;


import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@TableName("user_info")
@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Integer id;
    @Column(name = "stu_id", length = 7)
    private Integer stuId;
    private String username;
    private String position;
    private String password;
    @Column(name = "phone_num")
    private String phoneNum;
    private String intro;
    @Column(name = "re_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reDate;

}
