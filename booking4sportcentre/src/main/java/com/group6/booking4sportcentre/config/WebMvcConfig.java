package com.group6.booking4sportcentre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/adminSportActivitiesPage.html");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/userHomepage.html/**");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/userInformation.html/**");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/userWallet.html/**");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/userBooking.html/**");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/football.html/**");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/basketball.html/**");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/tennis.html/**");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/archery.html/**");

    }
}

