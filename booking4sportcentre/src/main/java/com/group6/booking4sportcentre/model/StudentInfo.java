package com.group6.booking4sportcentre.model;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@TableName("student_info")
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "position")
    private String position;

    @Column(name = "mobile_Phone")
    private String mobilePhone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "school_Email")
    private String schoolEmail;

    @Column(name = "emergency_ContactNumber")
    private String emergencyContactNumber;


}
