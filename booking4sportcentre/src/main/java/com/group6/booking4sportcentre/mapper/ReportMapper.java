package com.group6.booking4sportcentre.mapper;

import com.group6.booking4sportcentre.model.BookingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author Yixuan.Wang
 * @create 2024-05-2 18:15
 */

@Mapper
public interface ReportMapper {

    @Select("SELECT id, price, date FROM booking_info")
    List<BookingInfo> getAllBooking();


    @Select("SELECT MONTH(date) AS month, SUM(price) AS monthlyTotal FROM booking_info GROUP BY MONTH(date)")
    List<Map<String, Number>> getMonthlyTotal();

    @Select("SELECT MONTH(date) AS month, COUNT(*) AS rowcount FROM booking_info GROUP BY MONTH(date)")
    List<Map<String, Number>> getQuantityByMonth();
}
