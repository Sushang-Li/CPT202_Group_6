package com.group6.booking4sportcentre.mapper;

import com.group6.booking4sportcentre.model.BookingInfo;
import org.apache.ibatis.annotations.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Fuyu.Xing
 * @create 2024-04-20 22:17
 */

// Mapper for manipulating the booking_info database
@Mapper
public interface BookingInfoMapper {
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
    @Insert("INSERT INTO booking_info(date, start_time, end_time, venue, status, name, price) VALUES(#{date}, #{startTime}, #{endTime}, #{venue}, #{status}, #{name}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createBooking(BookingInfo booking);

    // Update a booking
    @Update("UPDATE booking_info SET date = #{booking.date}, start_time = #{booking.startTime}, end_time = #{booking.endTime}, venue = #{booking.venue}, status = #{booking.status}, name = #{booking.name}, price = #{booking.price} WHERE id = #{id}")
    int updateBooking(@Param("id") Long id, @Param("booking") BookingInfo booking);

    @Delete("DELETE FROM booking_info WHERE id = #{id}")
    int deleteBooking(@Param("id") Long id);
}
