package com.redis.controller;


import com.alibaba.fastjson.JSONObject;

import com.redis.entity.User;
import com.redis.mapper.UserMapper;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/all")
    public JSONObject findAll () {

        List<User> userList = userMapper.findAll();
        for(User u : userList){
            logger.debug(u.toString());
//            System.out.println(u.toString());
        }

        JSONObject json = new JSONObject();
        json.put("data",userList);
        return json;
    }

    @RequestMapping("/find")
    public JSONObject findOne(int id) {
        User user = userMapper.findOne(id);
        JSONObject json = new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/add")
    public void addOne (User user) {
        userMapper.addOne(user);
    }

    @RequestMapping("/del")
    public void delOne (int id) {
        userMapper.delOne (id);
    }

    @RequestMapping("/update")
    public void updateOne (User user) {
        userMapper.updateOne (user);
    }
}
