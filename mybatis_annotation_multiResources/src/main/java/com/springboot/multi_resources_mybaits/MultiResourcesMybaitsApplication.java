package com.springboot.multi_resources_mybaits;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class MultiResourcesMybaitsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MultiResourcesMybaitsApplication.class, args);
	}
}
