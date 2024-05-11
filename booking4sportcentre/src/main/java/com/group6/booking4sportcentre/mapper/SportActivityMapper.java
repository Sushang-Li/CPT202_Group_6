package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.SportActivity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SportActivityMapper extends BaseMapper<SportActivity> {



    @Select("select * from sport_activity")
    public List<SportActivity> list();

    @Select("select * from sport_activity where id=#{id}")
    public List<SportActivity> getById(@Param("id") int id);

    @Update("UPDATE sport_activity SET name = #{name}, start_time = #{startTime}, end_time = #{endTime}, " +
            "coach = #{coach}, stadium = #{stadium}, price = #{price}, ticket_number = #{ticketNumber} " +
            "WHERE id = #{id}")
    int update(SportActivity sportActivity);

    @Insert("INSERT INTO sport_activity(id, coach, end_time, name, price, stadium, start_time, ticket_number) " +
            "VALUES(#{id}, #{coach}, #{endTime}, #{name}, #{price}, #{stadium}, #{startTime},#{ticketNumber})")
    int add(SportActivity sportActivity);

    @Delete("Delete from sport_activity where id =#{id}")
    int delete(int id);
}
