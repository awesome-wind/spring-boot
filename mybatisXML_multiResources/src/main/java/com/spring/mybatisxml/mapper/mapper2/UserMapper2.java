package com.spring.mybatisxml.mapper.mapper2;

import com.spring.mybatisxml.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface UserMapper2 {
    List<User> findAll();

    User findOne(Integer id);

    void addOne(User user);

    void updateOne(User user);

    void delOne(Integer id);
}
