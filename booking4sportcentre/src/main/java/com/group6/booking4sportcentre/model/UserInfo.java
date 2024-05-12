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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public LocalDate getReDate() {
        return reDate;
    }

    public void setReDate(LocalDate reDate) {
        this.reDate = reDate;
    }
}
