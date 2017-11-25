package com.spring.boot.service;

import com.spring.boot.entity.User;
import com.spring.boot.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServiceImpl implements MyService{
    @Autowired
    MyRepository myRepository;

    @Override
    public List<User> findAll() {
        return myRepository.findAll();
    }

    @Override
    public void addOne(User user) {
        myRepository.saveAndFlush(user);
    }

    @Override
    public void delOne(Integer id) {
        myRepository.delete(id);
    }

    @Override
    public User findOne(Integer id) {
        return myRepository.findOne(id);
    }

    @Override
    public User modifyOne(User user) {
        myRepository.modifyOne(user.getUserName(),user.getPassword(),user.getAuthority(),user.getPhone(),user.getId());
        return myRepository.findOne(user.getId());
    }
}
