package com.group6.booking4sportcentre.mapper;

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
    @Insert("INSERT INTO booking_info(user_name, date, start_time, end_time, venue, status, act_name, price) VALUES(#{userName},#{date}, #{startTime}, #{endTime}, #{venue}, #{status}, #{actName}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createBooking(BookingInfo booking);

    // Update a booking
    @Update("UPDATE booking_info SET user_name = #{booking.userName},date = #{booking.date}, start_time = #{booking.startTime}, end_time = #{booking.endTime}, venue = #{booking.venue}, status = #{booking.status}, act_name = #{booking.actName}, price = #{booking.price} WHERE id = #{id}")
    int updateBooking(@Param("id") Long id, @Param("booking") BookingInfo booking);

    // Delete a booking
    @Delete("DELETE FROM booking_info WHERE id = #{id}")
    int deleteBooking(@Param("id") Long id);

    //
    @Select("SELECT price, wallet_info_id FROM booking_info WHERE id = #{id}")
    Map<String, Object> getBookingCostAndWalletInfoIdById(@Param("id") Long id);


    @Update("UPDATE booking_info SET wallet_info_id = #{walletInfoId} WHERE id = #{bookingInfoId}")
    void updateWalletInfoId(@Param("bookingInfoId") Long bookingInfoId, @Param("walletInfoId") Long walletInfoId);

}

