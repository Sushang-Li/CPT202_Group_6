package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.AdminLoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AdminLoginControllerTest {
    @Autowired
    private AdminLoginController adminLoginController;

    @Test
    public void testAdminLogin() {
        String result = adminLoginController.adminLogin("admin", "admin");
        // Assert that the result is not empty
        assertNotNull(result);
    }

    @Test
    public void testLogin() {
        String result = adminLoginController.login("admin", "admin", null);
        // Assert that the result is not empty
        assertNotNull(result);
    }


}
