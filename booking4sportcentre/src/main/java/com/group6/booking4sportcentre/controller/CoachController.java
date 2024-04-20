package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.CoachInfoMapper;
import com.group6.booking4sportcentre.model.CoachInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mingyuan.Li
 * @create 2024-04-20 15:13
 */

// This class is used to control the view of the coach, the administrator can view the coach's information
@RestController
public class CoachController {
    @Autowired
    private CoachInfoMapper coachInfoMapper;

    // Get all coach information
    // If there is no coach information, return empty list
    @GetMapping("/api/coachinfo")
    public List<CoachInfo> viewCoachInfo() {
        return coachInfoMapper.selectList(null);
    }

    // Get the coach information according to the name（For search function）
    // If the search name is empty, return empty list
    @PostMapping("/api/coach_by_name")
    public List<CoachInfo> getCoachByName(@RequestParam String name) {
        return coachInfoMapper.selectByName(name);
    }

    // Add coach information
    @PostMapping("/api/add_coach")
    public String addCoachInfo(CoachInfo coachInfo) {
        int i = coachInfoMapper.insert(coachInfo);
        if (i == 0) {
            return "Add coach information failed";
        }
        return "Add coach information successfully";
    }

    // Update coach information
    @PostMapping("/api/update_coach")
    public String updateCoachInfo(CoachInfo coachInfo) {
        int i = coachInfoMapper.updateById(coachInfo);
        if (i == 0) {
            return "Update coach information failed";
        }
        return "Update coach information successfully";
    }

    // Delete coach information
    @PostMapping("/api/delete_coach")
    public String deleteCoachInfo(@RequestParam Integer id) {
        int i = coachInfoMapper.deleteById(id);
        if (i == 0) {
            return "Delete coach information failed";
        }
        return "Delete coach information successfully";
    }

}
