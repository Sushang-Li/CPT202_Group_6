package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.SportActivityMapper;
import com.group6.booking4sportcentre.model.SportActivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
/*@CrossOrigin(origins="*")*/
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})


@RestController
@RequestMapping("/api/sportActivity")
public class SportActivityController {
    @Autowired
    private SportActivityMapper sportActivityMapper;
    @GetMapping
    public List<SportActivity> list(){
    return sportActivityMapper.list();
    }

   /* @PutMapping("/update/{id}")*/
   @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody SportActivity sportActivity) {
        // 设置要更新的体育活动的 ID
       sportActivity.setId(id);
       sportActivityMapper.update(sportActivity);
        // 调用 Mapper 接口中的更新方法
        int rowsAffected = sportActivityMapper.update(sportActivity);

        if (rowsAffected > 0) {
            return "Sport activity updated successfully";
        } else {
            return "Failed to update sport activity";
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody SportActivity sportActivity){
        log.info("体育活动为"+ sportActivity);
        sportActivityMapper.add(sportActivity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSportActivity(@PathVariable int id) {
        int rowsAffected = sportActivityMapper.delete(id);
        if (rowsAffected > 0) {
            return "Sport activity with ID " + id + " has been deleted successfully.";
        } else {
            return "Failed to delete sport activity with ID " + id + ". Please check the ID.";
        }
    }
}
