package com.spring.boot.service;

import com.spring.boot.entity.User;

import java.util.List;

public interface MyService {
    List<User> findAll();

    void addOne(User user);

    void delOne(Integer id);

    User findOne(Integer id);

    User modifyOne(User user);
}
