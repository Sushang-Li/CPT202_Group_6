package com.group6.booking4sportcentre.model;

import java.util.ArrayList;
import java.util.List;

public class Message {
    //Message returned when verifying success
    public String message;
    //Message content
    public List<UserInfo> objects = new ArrayList<UserInfo>();
}
