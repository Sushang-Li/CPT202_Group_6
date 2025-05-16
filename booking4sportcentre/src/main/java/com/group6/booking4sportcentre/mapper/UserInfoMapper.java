package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo>{

    @Select("SELECT * FROM user_info WHERE stu_id = #{username} AND password = #{password}")
    UserInfo selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    //Get all student registration information
    @Select("select * from user_info")
    List<UserInfo> findAll();

    // 新增分页查询方法
    @Select("SELECT * FROM user_info LIMIT #{limit} OFFSET #{offset}")
    List<UserInfo> findByPage(@Param("offset") int offset, @Param("limit") int limit);

    // 新增查询总记录数方法
    @Select("SELECT COUNT(*) FROM user_info")
    int selectTotalCount();

    //Get student registration information by id
    @Select("select * from user_info where id = #{id}")
    UserInfo selectById(Integer id);

    @Update("UPDATE user_info SET balance = #{newBalance} WHERE id = #{userId}")
    void updateBalance(@Param("userId") int userId, @Param("newBalance") Double newBalance);

    @Select("SELECT balance FROM user_info WHERE id = #{userId}")
    double getBalance(@Param("userId") int userId);



/*
    @Select("SELECT * FROM user_info WHERE id = #{id}")
    UserInfo getUserById(@Param("id") Integer id);*/

//    @Insert("INSERT INTO user_info (stu_id, email, password, first_name, last_name, dob, phone, address, gender) " +
//            "VALUES (#{stuId}, #{email}, #{password}, #{firstName}, #{lastName}, #{dob}, #{phone}, #{address}, #{gender})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")  // 使MyBatis自动处理ID的生成
//    void insertUser(UserInfo userInfo);

}
