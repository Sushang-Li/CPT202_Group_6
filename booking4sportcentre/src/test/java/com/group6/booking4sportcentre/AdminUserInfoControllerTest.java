package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.AdminUserInfoController;
import com.group6.booking4sportcentre.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Yixuan.Wang
 * @create 2024-04-22 16:20
 */

@SpringBootTest
public class AdminUserInfoControllerTest {
    @Autowired
    private AdminUserInfoController adminUserInfoController;

    //Test findAll method
    @Test
    public void testFindAll(){
        List<UserInfo> userInfoList = adminUserInfoController.findAll();
        // Assert that the result is not empty
        assertNotNull(userInfoList);
    }

    //Test findById method
    @Test
    public void testFindById(){
        UserInfo userInfoList = adminUserInfoController.findById(1);
        // Assert that the result is not empty
        assertNotNull(userInfoList);
    }


    //Test addStudent method
    @Test
    public void testAddUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2145058);
        userInfo.setStuId(2145058);
        userInfo.setUsername("2145058");
        userInfo.setPosition("Student");
        userInfo.setPassword("12345678");
        userInfo.setPhoneNum("13728472843");
        userInfo.setIntro("w");
        userInfo.setFirstName("Yixuan");
        userInfo.setLastName("Wang");
        userInfo.setEmail("123");
        userInfo.setDob(LocalDate.ofEpochDay(2024-04-22));
        userInfo.setAddress("123");
        userInfo.setGender(1);

        // Assert that the result is not empty
        assertNotNull(adminUserInfoController.addUser(userInfo));
    }

    //Test updateStudent method
    @Test
    public void testUpdateUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2145058);
        userInfo.setStuId(2145058);
        userInfo.setUsername("2145058");
        userInfo.setPosition("Student");
        userInfo.setPassword("12345678");
        userInfo.setPhoneNum("13728472843");
        userInfo.setIntro("w");
        // Assert that the result is not empty
        assertNotNull(adminUserInfoController.updateUser(userInfo));
    }

    //Test deleteStudent method
    @Test
    public void testDeleteUser(){
        // Assert that the result is not empty
        assertNotNull(adminUserInfoController.deleteUser(2105058));
    }

}
