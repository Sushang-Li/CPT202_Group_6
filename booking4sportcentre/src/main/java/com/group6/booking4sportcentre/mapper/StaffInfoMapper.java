package com.group6.booking4sportcentre.mapper;

import com.group6.booking4sportcentre.model.StaffInfo;
import com.group6.booking4sportcentre.model.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface StaffInfoMapper {
    //Get all student registration information
    @Select("select * from staff_info")
    List<StaffInfo> findAll();

    //Get student registration information by id
    @Select("select * from staff_info where id = #{id}")
    List<StaffInfo> selectById(Integer id);


    int insert(StaffInfo staffInfo);

    int updateById(StaffInfo staffInfo);

    int deleteById(Integer id);
}
