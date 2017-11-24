package com.spring.mybatisxml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.mybatisxml.mybatis.mapper")  //这样就不用在每个mapper接口上加Mapper,在非注解方式不可用
public class MybatisxmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisxmlApplication.class, args);
	}
}
