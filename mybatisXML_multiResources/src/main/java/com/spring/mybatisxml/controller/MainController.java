package com.spring.mybatisxml.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.mybatisxml.entity.User;

import com.spring.mybatisxml.mapper.mapper1.UserMapper1;
import com.spring.mybatisxml.mapper.mapper2.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserMapper1 userMapper1;
    @Autowired
    private UserMapper2 userMapper2;

    @RequestMapping("/all")
    public JSONObject findAll(){
        List<User> users1 = userMapper1.findAll();
        List<User> users2 = userMapper2.findAll();
        users1.addAll(users2);
        JSONObject json = new JSONObject();
        json.put("data",users1);
        return json;
    }
    /*** 数据库1操作 ***/
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

    /*** 数据库2操作 ***/
    @RequestMapping("/find2")
    public JSONObject findOne2(Integer id){
        User user = userMapper2.findOne(id);
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/add2")
    public void addOne2(User user){
        userMapper2.addOne(user);
    }

    @RequestMapping("/update2")
    public void updateOne2(User user){
        userMapper2.updateOne(user);
    }

    @RequestMapping("/del2")
    public void delOne2(Integer id){
        userMapper2.delOne(id);
    }
}
