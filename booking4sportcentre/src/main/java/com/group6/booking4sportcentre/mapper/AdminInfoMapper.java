package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.AdminInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Mingyuan.Li
 * @create 2024-04-19 19:24
 */
// 用于操作Admin_info数据库的mapper
// mapper for manipulating the Admin_info database
@Mapper
public interface AdminInfoMapper extends BaseMapper<AdminInfo> {
}
