package com.group6.booking4sportcentre.repository;

import com.group6.booking4sportcentre.model.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public class Message {
    //Message returned when verifying success
    public String message;
    //Message content
    public List<StudentInfo> objects = new ArrayList<StudentInfo>();

}
