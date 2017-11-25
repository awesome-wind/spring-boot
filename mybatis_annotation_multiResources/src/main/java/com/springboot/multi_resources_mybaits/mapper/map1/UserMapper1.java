package com.springboot.multi_resources_mybaits.mapper.map1;

import com.springboot.multi_resources_mybaits.entity.User;
import com.springboot.multi_resources_mybaits.enums.AuthorityEnum;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface UserMapper1 {
    //如果没有返回结果则不需要加Result解析，在Sql语句中必须使用标准的语句，想userName是允许的
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userName",column = "user_name"),
            @Result(property = "authority",column = "authority",javaType = AuthorityEnum.class)
    })
    List<User> findAll();

    @Insert("INSERT INTO user(user_name,authority) VALUES(#{userName},#{authority})")
    @Results({
            @Result(property = "userName",column = "user_name"),
            @Result(property = "authority",column = "authority",javaType = AuthorityEnum.class)
    })
    void addOne(User user);

    @Select("SELECT * FROM user WHERE id=#{id}")
    @Results({
            @Result(column = "user_name",property = "userName"),
            @Result(column = "authority",property = "authority",javaType = AuthorityEnum.class)
    })
    User findOne(Integer id);

    @Update("UPDATE user SET user_name = #{userName},authority = #{authority} WHERE id = #{id}")
    void updateOne(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void delOne(Integer id);
}
