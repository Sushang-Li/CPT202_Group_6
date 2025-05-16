package com.group6.booking4sportcentre.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "图像验证码")
@AllArgsConstructor
public class CaptchaVo {

    @Schema(description = "验证图片码信息")
    private String image;

    @Schema(description = "验证码key")
    private String key;
}
