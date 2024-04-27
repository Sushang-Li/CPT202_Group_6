package com.group6.booking4sportcentre.mapper;

import com.group6.booking4sportcentre.model.SportActivity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SportActivityMapper {
    @Select("select * from sport_activity")
    public List<SportActivity> list();

    @Update("UPDATE sport_activity SET name = #{name}, startTime = #{startTime}, endTime = #{endTime}, " +
            "coach = #{coach}, stadium = #{stadium}, price = #{price}, ticketNumber = #{ticketNumber} " +
            "WHERE id = #{id}")
    public int update(SportActivity sportActivity);

    @Insert("INSERT INTO sport_activity(id, coach, end_time, name, price, stadium, start_time, ticket_number) " +
            "VALUES(#{id}, #{coach}, #{endTime}, #{name}, #{price}, #{stadium}, #{startTime},#{ticketNumber})")
    public void add(SportActivity sportActivity);

    @Delete("Delete from sport_activity where id =#{id}")
    public int delete(int id);
}
