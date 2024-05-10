package com.group6.booking4sportcentre.mapper;

import com.group6.booking4sportcentre.model.Stadium;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StadiumMapper {
    @Select("select * from stadium")
    public List<Stadium> list();

    @Select("select * from stadium where id=#{id}")
    public List<Stadium> getById(@Param("id") int id);

    @Update("UPDATE stadium SET name = #{name} , activity_name = #{activityName} , remaining_space=#{remainingSpace} " +
            "WHERE id = #{id}")
    int update(Stadium stadium);

    @Insert("INSERT INTO stadium(id, activity_name, name, remaining_space) " +
            "VALUES(#{id}, #{activityName}, #{name}, #{remainingSpace})")
    int add(Stadium stadium);

    @Delete("Delete from stadium where id =#{id}")
    int delete(int id);
}
