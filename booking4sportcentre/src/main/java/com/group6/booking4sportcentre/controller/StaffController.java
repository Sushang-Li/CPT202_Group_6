package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.StaffInfoMapper;
import com.group6.booking4sportcentre.model.Message;
import com.group6.booking4sportcentre.model.StaffInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yixuan.Wang
 * @create 2024-04-22 18:24
 */
//This class is used by administrators to manage staff registration information
@RestController
public class StaffController {
    @Autowired
    private StaffInfoMapper staffInfoMapper;

    //View all student registration information
    @GetMapping("StaffInfo")
    public List<StaffInfo> findAll() {

        return staffInfoMapper.findAll();
    }

    //View student registration by id
    @GetMapping("getStaffById")
    public List<StaffInfo> findById(Integer id){

        return staffInfoMapper.selectById(id);
    }

    //Add student registration information
    @PostMapping("/addStaff")
    public Message addStaff(StaffInfo staffInfo){
        int add = staffInfoMapper.insert(staffInfo);
        //Message returned during verification
        Message mes = new Message();
        mes.message = "Added successfully!";
        //Return the added information
        mes.result = staffInfoMapper.findAll();
        return mes;

    }


    //Update student registration information
    @Transactional
    @PostMapping("/updateStaff")
    public Message updateStaff(StaffInfo staffInfo) {
        int i = staffInfoMapper.updateById(staffInfo);
        if (i == 0) {
            //Message returned during verification
            Message mes = new Message();
            mes.message = "Update failed!";
        }
        Message mes = new Message();
        mes.message = "Update successful!";
        //Return the updated information
        mes.result = staffInfoMapper.findAll();
        return mes;
    }


    //Delete student registration information
    @Transactional
    @DeleteMapping("/deleteStaff")
    public Message deleteStaff(Integer id) {
        int i = staffInfoMapper.deleteById(id);
        if (i == 0){
            //Message returned during verification
            Message mes = new Message();
            mes.message = "Delete failed!";
            return mes;
        }
        else {
            Message mes = new Message();
            mes.message = "Delete successful!";
            //Return the deleted information
            mes.result = staffInfoMapper.findAll();
            return mes;
        }
    }
}
