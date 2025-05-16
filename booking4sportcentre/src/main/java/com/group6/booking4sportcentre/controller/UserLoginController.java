package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.constant.RedisConstant;
import com.group6.booking4sportcentre.mapper.UserInfoMapper;
import com.group6.booking4sportcentre.model.UserInfo;
import com.group6.booking4sportcentre.model.vo.CaptchaVo;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Controller
@RequiredArgsConstructor
public class UserLoginController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    private final StringRedisTemplate redisTemplate;

    @PostMapping("/stuLogin")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("captchaKey") String captchaKey,
                        @RequestParam("verification") String verificationCode,
                        HttpSession session) {
        System.out.println("login");

        //校验图形验证码
        if (verificationCode == null || verificationCode.isEmpty() || captchaKey == null || captchaKey.isEmpty()) {
            return "redirect:/userLogin.html?error";
        }
        String code = redisTemplate.opsForValue().get(captchaKey);
        if (code == null || !code.equals(verificationCode.toLowerCase())) {
            return "redirect:/userLogin.html?error";
        }

        // 调用UserInfoMapper进行验证
        UserInfo user = userInfoMapper.selectByUsernameAndPassword(username, password);
        if (user != null) {
            // 登录成功，将用户信息存储到Session中
            session.setAttribute("user", user);

            //得到登录用户的ID
            UserInfo userInfo = (UserInfo) session.getAttribute("user");
            Integer userId = userInfo.getId();

            //把用户ID传给前端用于增删改查，前端从后端获取ID的唯一方式，之后ID在前端页面间相互传递
            return "redirect:/userHomepage.html" + "?id=" + userId; // 登录成功后跳转到用户首页
        } else {
            return "redirect:/userLogin.html?error"; // 登录失败，重定向到登录页面并显示错误消息
        }
    }

    // 添加登出方法
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // 使当前会话失效
        session.invalidate();
        // 重定向到登陆页面
        return "redirect:/index.html";
    }


    //获取登录时图形验证码
    @GetMapping("/api/captcha")
    @ResponseBody
    public CaptchaVo getCaptcha() {
        System.out.println("/api/captcha/: 获取验证码\t" + LocalDateTime.now());
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        specCaptcha.setCharType(Captcha.FONT_1);

        String code = specCaptcha.text().toLowerCase();
        String key = RedisConstant.USER_LOGIN_PREFIX + UUID.randomUUID();
        String image = specCaptcha.toBase64();

        redisTemplate.opsForValue().set(key, code, RedisConstant.USER_LOGIN_CODE_TTL_SEC, TimeUnit.SECONDS);

        return new CaptchaVo(image, key);
    }
}
