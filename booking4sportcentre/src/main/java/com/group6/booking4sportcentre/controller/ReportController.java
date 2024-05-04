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
    @Transactional
    public Map<String, Object> getMonthlySalesAndQuantity() {
        List<Map<String, Number>> monthlyTotalList = reportMapper.getMonthlyTotal();
        List<Map<String, Number>> monthlyQuantityList = reportMapper.getQuantityByMonth();

        Map<String, Object> results = new HashMap<>();
        // Convert List to Map for easy matching
        Map<String, Number> monthlyTotalMap = new HashMap<>();
        for (Map<String, Number> map : monthlyTotalList) {
            monthlyTotalMap.put(map.get("month").toString(), map.get("monthlyTotal"));
        }

        // Loop through quantity list, match with total Map
        for (Map<String, Number> map : monthlyQuantityList) {
            Map<String, Object> monthData = new HashMap<>();
            monthData.put("total", monthlyTotalMap.get(map.get("month").toString()));
            monthData.put("quantity", map.get("rowcount"));
            results.put(map.get("month").toString(), monthData);
        }

        return results;
    }

}

