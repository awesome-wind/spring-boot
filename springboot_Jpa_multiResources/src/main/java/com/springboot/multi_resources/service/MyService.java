package com.springboot.multi_resources.service;



import com.springboot.multi_resources.entity.user.User;
import com.springboot.multi_resources.entity.work.Work;

import java.util.List;

public interface MyService {
    List<User> findAll();

    void addOne(User user);

    void delOne(Integer id);

    User findOne(Integer id);

    User modifyOne(User user);

    List<Work> findWorkAll();
}
