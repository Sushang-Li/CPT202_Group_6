package com.group6.booking4sportcentre.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group6.booking4sportcentre.model.BookingInfo;
import org.apache.ibatis.annotations.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Fuyu.Xing
 * @create 2024-04-20 22:17
 */

// Mapper for manipulating the booking_info database
@Mapper
public interface BookingInfoMapper extends BaseMapper<BookingInfo> {
    //添加使用mybatisPlus
    //

    //下面的内容都是邢富玉之前写的，暂时未更改
    // Get all bookings
    @Select("SELECT * FROM booking_info")
    List<BookingInfo> getAllBookings();

    // Get booking by id
    @Select("SELECT * FROM booking_info WHERE id = #{id}")
    BookingInfo getBookingById(@Param("id") Long id);

    //Get booking by date
    @Select("SELECT * FROM booking_info WHERE date = #{date}")
    List<BookingInfo> getBookingByDate(@Param("date") LocalDate date);

    // Create a booking
    @Insert("INSERT INTO booking_info(user_name, user_id, date, start_time, end_time, venue, status, act_name, price) VALUES(#{userName},#{userId},#{date}, #{startTime}, #{endTime}, #{venue}, #{status}, #{actName}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createBooking(BookingInfo booking);

    // Update a booking
    @Update("UPDATE booking_info SET user_name = #{booking.userName},user_id = #{booking.userId}, date = #{booking.date}, start_time = #{booking.startTime}, end_time = #{booking.endTime}, venue = #{booking.venue}, status = #{booking.status}, act_name = #{booking.actName}, price = #{booking.price} WHERE id = #{id}")
    int updateBooking(@Param("id") Long id, @Param("booking") BookingInfo booking);

    // Delete a booking
    @Delete("DELETE FROM booking_info WHERE id = #{id}")
    int deleteBooking(@Param("id") Long id);






}

