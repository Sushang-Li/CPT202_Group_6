package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.AdminInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


// mapper for manipulating the Admin_info database
@Mapper
public interface AdminInfoMapper extends BaseMapper<AdminInfo> {
    @Select("SELECT * FROM admin_info WHERE username = #{username} AND password = #{password}")
    AdminInfo selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
