package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.UserController;
import com.group6.booking4sportcentre.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    private UserController userController;

    @Test
    public void testRegisterUser() {
        // Setting up a mock HttpServletRequest and RedirectAttributes
        MockHttpServletRequest request = new MockHttpServletRequest();
        RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();

        // Creating a sample user info for the test
        UserInfo userInfo = new UserInfo();
        userInfo.setStuId(123);
        userInfo.setEmail("test@example.com");
        userInfo.setFirstName("John");
        userInfo.setLastName("Doe");
        userInfo.setDob(LocalDate.of(1990, 1, 1));
        userInfo.setAddress("123 Main St");
        userInfo.setGender(1);
        userInfo.setPassword("password123");
        userInfo.setPhoneNum("5551234567");

        // Calling the register method
        String result = userController.register(
                userInfo.getStuId(),
                userInfo.getEmail(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getDob().toString(),
                userInfo.getAddress(),
                userInfo.getGender(),
                userInfo.getPassword(),
                userInfo.getPhoneNum(),
                redirectAttributes
        );

        // Asserting that the redirect URL is correct
        assertEquals("redirect:/userLogin.html", result);

        // Checking that a message attribute was added to show registration was successful
        assertNotNull(redirectAttributes.getFlashAttributes().get("message"));
        assertEquals("注册成功！", redirectAttributes.getFlashAttributes().get("message"));
    }
}

