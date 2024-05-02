package com.group6.booking4sportcentre.mapper;

import com.group6.booking4sportcentre.model.BookingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yixuan.Wang
 * @create 2024-05-2 18:15
 */

@Mapper
public interface ReportMapper {
    @Select("SELECT id, price, date, quantity FROM booking_info")
    List<BookingInfo> getAllBooking();
}
