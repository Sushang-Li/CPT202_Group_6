package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.SportActivityMapper;
import com.group6.booking4sportcentre.mapper.StadiumMapper;
import com.group6.booking4sportcentre.model.SportActivity;
import com.group6.booking4sportcentre.model.Stadium;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
/*@CrossOrigin(origins="*")*/
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})


@RestController
@RequestMapping("/api/stadium")
public class StadiumController {
    @Autowired
    private StadiumMapper stadiumMapper;

    //查看全部体育活动
    @GetMapping
    public List<Stadium> list(){
        return stadiumMapper.list();
    }

    //查看特定id的体育活动
    @GetMapping("/{id}")
    public List<Stadium> getById(@PathVariable int id){
        return  stadiumMapper.getById(id);
    }

   @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Stadium stadium) {
        // 设置要更新的体育活动的 ID
       stadium.setId(id);
        // 调用 Mapper 接口中的更新方法
        int rowsAffected = stadiumMapper.update(stadium);

        if (rowsAffected > 0) {
            return "Stadium updated successfully";
        } else {
            return "Failed to update sport activity";
        }
    }
    @PostMapping("/add")
    public String add(@RequestBody Stadium stadium){
       int i= stadiumMapper.add(stadium);
       if(i == 0){
           return "Failed to add stadium";
       }
         return "Stadium added successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        int rowsAffected = stadiumMapper.delete(id);
        if (rowsAffected > 0) {
            return "Stadium with ID " + id + " has been deleted successfully.";
        } else {
            return "Failed to delete Stadium with ID " + id + ". Please check the ID.";
        }
    }
}
