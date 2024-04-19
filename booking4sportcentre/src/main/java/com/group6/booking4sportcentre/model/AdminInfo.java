package com.group6.booking4sportcentre.model;

import com.baomidou.mybatisplus.annotation.TableName;
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
public class AdminInfo {
    private String username;
    private String password;
}
