package com.spring.mybatisxml.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.mybatisxml.entity.User;

import com.spring.mybatisxml.mapper.UserMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserMapper1 userMapper1;

    @RequestMapping("/all")
    public JSONObject findAll(){
        List<User> users = userMapper1.findAll();
        JSONObject json = new JSONObject();
        json.put("data",users);
        return json;
    }

    @RequestMapping("/find1")
    public JSONObject findOne(Integer id){
        User user = userMapper1.findOne(id);
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/add1")
    public void addOne(User user){
        userMapper1.addOne(user);
    }

    @RequestMapping("/update1")
    public void updateOne(User user){
        userMapper1.updateOne(user);
    }

    @RequestMapping("/del1")
    public void delOne(Integer id){
        userMapper1.delOne(id);
    }
}
