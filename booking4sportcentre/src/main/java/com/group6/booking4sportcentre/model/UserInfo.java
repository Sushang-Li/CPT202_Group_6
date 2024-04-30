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
    @Column(name = "email", nullable = false)
    private String email; // 用户的电子邮箱
    @Column(name = "first_name", nullable = false)
    private String firstName; // 用户的名字
    @Column(name = "last_name", nullable = false)
    private String lastName; // 用户的姓氏
    @Column(name = "dob", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob; // 用户的生日
    @Column(name = "address", nullable = false)
    private String address; // 用户的地址
    @Column(name = "gender", nullable = false)
    private Integer gender; // 用户的性别（例如：1为男，2为女）
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
