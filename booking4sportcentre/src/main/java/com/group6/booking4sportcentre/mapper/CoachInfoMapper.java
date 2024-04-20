package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.CoachInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Mingyuan.Li
 * @create 2024-04-20 15:12
 */
// mapper for manipulating the coach_info database
@Mapper
public interface CoachInfoMapper extends BaseMapper<CoachInfo> {
//    Get certain coaches information by name
    @Select("SELECT * FROM coach_info WHERE name = #{name}")
    List<CoachInfo> selectByName(String name);

}
