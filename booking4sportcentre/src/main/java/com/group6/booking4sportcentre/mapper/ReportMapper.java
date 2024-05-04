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
    @Select("SELECT id, price, date FROM booking_info")
    List<BookingInfo> getAllBooking();

    @Select("SELECT COUNT(*) FROM information_schema. COLUMNS WHERE table_schema = 'sport_centre' AND table_name = 'booking_info'")
    int getQuantity();
}
