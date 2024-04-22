package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.StudentMapper;
import com.group6.booking4sportcentre.model.StudentInfo;
import com.group6.booking4sportcentre.repository.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yixuan.Wang
 * @create 2024-04-22 10:24
 */
//This class is used by administrators to manage student registration information
@RestController
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    //View all student registration information
    @GetMapping("StuInfo")
    public List<StudentInfo> findAll() {
        return studentMapper.findAll();
    }

    //View student registration by id
    @GetMapping("getStudentById")
    public List<StudentInfo> findById(Integer id){
        return studentMapper.selectById(id);
    }

    //Add student registration information
    @PostMapping("/addStudent")
    public Message addStudent(StudentInfo studentInfo){
        int add = studentMapper.insert(studentInfo);
        //Message returned during verification
        Message mes = new Message();
        mes.message = "Added successfully!";
        //Return the added information
        mes.objects = studentMapper.findAll();
        return mes;

    }


    //Update student registration information
    @Transactional
    @PostMapping("/updateStudent")
    public Message updateStudent(StudentInfo studentInfo) {
        int i = studentMapper.updateById(studentInfo);
        if (i == 0) {
            //Message returned during verification
            Message mes = new Message();
            mes.message = "Update failed!";
        }
            Message mes = new Message();
            mes.message = "Update successful!";
            //Return the updated information
            mes.objects = studentMapper.findAll();
            return mes;
        }


    //Delete student registration information
    @Transactional
    @DeleteMapping("/deleteStudent")
    public Message deleteStudent(Integer id) {
        int i = studentMapper.deleteById(id);
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
            mes.objects = studentMapper.findAll();
            return mes;
        }
    }



}
