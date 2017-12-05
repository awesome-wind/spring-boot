package com.redis.mapper;


import com.redis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
@CacheNamespace(implementation = com.redis.cache.MybatisRedisCache.class)
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(name,sex,age) values (#{name},#{sex},#{age})")
    void addOne(User user);

    @Delete("delete from user where id = #{id}")
    void delOne(int id);

    @Update("update user set name=#{name},sex=#{sex},age=#{age} where id = #{id}")
    void updateOne(User user);

    @Select("select * from user where id = #{id}")
    User findOne(int id);
}
