package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.UserInfoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserInfoControllerTest {
    @Autowired
    private UserInfoController userInfoController;

    @Test
    public void testGetUserInfo(){
        assertNotNull(userInfoController.getUserInfo(1));
    }

    @Test
    public void testUpdateInfo(){
        userInfoController.updateInfo(1, "username", "password", "phoneNumber", "signature");
        // Assert that the result is not empty
        assertNotNull(userInfoController.getUserInfo(1));
    }


}
