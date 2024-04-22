package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.StudentInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;
// mapper for manipulating the student_info database
@Mapper
public interface StudentMapper extends BaseMapper<StudentInfo> {
    //Get all student registration information
    @Select("select * from student_info")
    List<StudentInfo> findAll();

    //Get student registration information by id
    @Select("select * from student_info where id = #{id}")
    List<StudentInfo> selectById(Integer id);

}
