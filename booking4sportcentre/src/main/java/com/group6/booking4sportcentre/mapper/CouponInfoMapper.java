package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.CouponInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CouponInfoMapper extends BaseMapper<CouponInfo> {
    @Select("SELECT * FROM coupon_info WHERE name = #{name}")
    CouponInfo selectByName(String name);

    @Select("SELECT * FROM coupon_info WHERE status = #{status}")
    List<CouponInfo> selectByStatus(String status);

    @Select("SELECT * FROM coupon_info WHERE user_id = #{userId} AND status = #{status}")
    List<CouponInfo> selectByUserIdAndStatus(Long userId, String status);

}
