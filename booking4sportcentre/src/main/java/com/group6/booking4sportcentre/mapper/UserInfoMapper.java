package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo>{
    @Select("SELECT * FROM user_info WHERE stu_id = #{username} AND password = #{password}")
    UserInfo selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    //Get all student registration information
    @Select("select * from user_info")
    List<UserInfo> findAll();

    //Get student registration information by id
    @Select("select * from user_info where id = #{id}")
    List<UserInfo> selectById(Integer id);



}
