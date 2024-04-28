package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo>{
    @Select("SELECT * FROM user_info WHERE stu_id = #{username} AND password = #{password}")
    UserInfo selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
