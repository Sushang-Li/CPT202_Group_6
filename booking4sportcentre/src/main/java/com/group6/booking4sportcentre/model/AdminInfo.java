package com.group6.booking4sportcentre.model;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author Mingyuan.Li
 * @create 2024-04-19 19:22
 */

// 管理员登陆信息表
// Administrator information table for login in
// Database: need to set up the username and password before running the program(Admin has to be set up manually)
@TableName("admin_info")
@Data
@Entity
public class AdminInfo {
    private String username;
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
