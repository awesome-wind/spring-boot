package com.springboot.multi_resources_mybaits.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.multi_resources_mybaits.entity.User;


import com.springboot.multi_resources_mybaits.mapper.map1.UserMapper1;
import com.springboot.multi_resources_mybaits.mapper.map2.UserMapper2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private UserMapper1 userMapper1;

    @Autowired
    private UserMapper2 userMapper2;

    @RequestMapping("/all")
    public JSONObject findAll(){
        List<User> userList1 = userMapper1.findAll();
        List<User> userList2 = userMapper2.findAll();
        userList1.addAll(userList2);
//        List<User> userList = new ArrayList<>();
//        userList.addAll(userList1);
//        userList.addAll(userList2);
        JSONObject json = new JSONObject();
        json.put("data",userList1);
        return json;
    }
    /***    数据库1  ***/
    @RequestMapping("/add1")
    public JSONObject addOne1(User user){
        userMapper1.addOne(user);
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/find1")
    public JSONObject findOne1(Integer id){
        User user = userMapper1.findOne(id);
        System.out.println(user.getId());
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/update1")
    public JSONObject update1(User user){
        userMapper1.updateOne(user);
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/del1")
    public void delOne1(Integer id){
        userMapper1.delOne(id);
    }

    /***    数据库2  ***/
    @RequestMapping("/add2")
    public JSONObject addOne2(User user){
        userMapper2.addOne(user);
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/find2")
    public JSONObject findOne2(Integer id){
        User user = userMapper2.findOne(id);
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/update2")
    public JSONObject update2(User user){
        userMapper2.updateOne(user);
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/del2")
    public void delOne2(Integer id){
        userMapper2.delOne(id);
    }
}
