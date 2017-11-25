package com.springboot.mybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.mybatis.entity.User;
import com.springboot.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableTransactionManagement
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/all")
    public JSONObject findAll(){
        List<User> userList = userMapper.findAll();
        JSONObject json =new JSONObject();
        json.put("data",userList);
        return json;
    }

    @RequestMapping("/add")
    public void addOne(User user){
        userMapper.addOne(user);
    }

    @RequestMapping("/update")
    public JSONObject update(User user){
        userMapper.update(user);
        JSONObject json =new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/find")
    public JSONObject findOne(int id){
        User user = userMapper.findOne(id);
        JSONObject json =new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/del")
    public void delOne(int id){
        userMapper.delOne(id);
    }

}
