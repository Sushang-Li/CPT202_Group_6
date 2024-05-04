package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.ReportMapper;
import com.group6.booking4sportcentre.model.BookingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yixuan.Wang
 * @create 2024-05-2 18:24
 */

@RestController
@RequestMapping
public class ReportController {
    private ReportMapper reportMapper;

    @Autowired
    public ReportController(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    @GetMapping("/api/report")
    public Map<String, Map<String, Object>> getMonthlySalesReport() {
        List<BookingInfo> tickets = reportMapper.getAllBooking();
        int quantity = reportMapper.getQuantity();

        Map<String, Map<String, Object>> monthlyData = new HashMap<>();

        for (BookingInfo ticket : tickets) {
            String month = ticket.getDate().getMonth().toString();

            if (!monthlyData.containsKey(month)) {
                monthlyData.put(month, new HashMap<>());
                monthlyData.get(month).put("totalTickets", quantity);
                monthlyData.get(month).put("totalSales", quantity * ticket.getPrice());
            } else {
                int totalTickets = (int) monthlyData.get(month).get("totalTickets") + quantity;
                double totalSales = (double) monthlyData.get(month).get("totalSales") + quantity * ticket.getPrice();
                monthlyData.get(month).put("totalTickets", totalTickets);
                monthlyData.get(month).put("totalSales", totalSales);
            }
        }
        return monthlyData;
    }
}