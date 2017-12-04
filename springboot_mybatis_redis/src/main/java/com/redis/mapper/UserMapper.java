package com.redis.mapper;


import com.redis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface UserMapper {

    List<User> findAll();

    void addOne(User user);

    void delOne(int id);

    void updateOne(User user);

    User findOne(int id);
}
