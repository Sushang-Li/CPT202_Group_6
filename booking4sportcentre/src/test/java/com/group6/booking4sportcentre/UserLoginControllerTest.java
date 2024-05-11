package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.UserLoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserLoginControllerTest {
    @Autowired
    private UserLoginController userLoginController;

    @Test
    public void testLoginSuccess() {
        // stu_id=1234567，密码为password1的用户
        String username = "1234567";
        String password = "password1";
        MockHttpSession session = new MockHttpSession();

        // 执行登录操作
        String result = userLoginController.login(username, password, session);

        // 验证用户是否正确存储在session中，且重定向地址正确
        assertNotNull(session.getAttribute("user"));
        assertTrue(result.contains("redirect:/userHomepage.html?id="));
    }

    @Test
    public void testLoginFailure() {
        String username = "user";
        String password = "wrong";
        MockHttpSession session = new MockHttpSession();

        // 执行登录操作
        String result = userLoginController.login(username, password, session);

        // 验证session中没有用户，且重定向到登录页面
        assertNull(session.getAttribute("user"));
        assertEquals("redirect:/userLogin.html?error", result);
    }
}
