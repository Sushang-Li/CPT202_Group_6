package com.group6.booking4sportcentre.config;

import com.group6.booking4sportcentre.model.AdminInfo;
import com.group6.booking4sportcentre.model.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/userLogin.html"); // 未登录，重定向到登录页面
            return false;
        }
        return true;
    }
}
