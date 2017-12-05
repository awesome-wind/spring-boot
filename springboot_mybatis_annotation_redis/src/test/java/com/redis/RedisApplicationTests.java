package com.redis;

import com.alibaba.fastjson.JSON;
import com.redis.entity.User;
import com.redis.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	private Logger logger = LoggerFactory.getLogger(RedisApplicationTests.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	User user = null;

//	@Before
//	public void testInsert() {
//		user = new User();
//		user.setName("测试");
//		user.setSex("男");
//		user.setAge(10);
//		userMapper.addOne(user);
//
//		Assert.assertNotNull(user.getId());
//		logger.debug(JSON.toJSONString(user));
//	}

	@Test
	public void testCache() {
		long begin = System.currentTimeMillis();
		List<User> persons = userMapper.findAll();
		long end1 = System.currentTimeMillis();
		userMapper.findAll();
		long end2 = System.currentTimeMillis();

		logger.debug("第一次请求时间：" + (end1 - begin) + "ms");
		logger.debug("第二次请求时间:" + (end2 - end1) + "ms");

		Assert.assertNotNull(persons);
		logger.debug(JSON.toJSONString(persons));
	}

//	 测试Redis存储和获取一个List
	@Test
	public void testRedisCacheSetList() {
		List<User> persons = new ArrayList<>();
		persons.add(user);
		persons.add(user);
		persons.add(user);
		redisTemplate.opsForValue().set(user.getId() + "", persons, 2, TimeUnit.MINUTES);
		persons = (List<User>) redisTemplate.opsForValue().get(user.getId() + "");
		System.out.println(JSON.toJSONString(persons));
	}

		// 测试Redis存储和获取一个Object
	@Test
	public void testRedisCacheSetObject() {
		redisTemplate.opsForValue().set(user.getId() + "", user, 2, TimeUnit.MINUTES);
		Object p = redisTemplate.opsForValue().get(user.getId() + "");
		if (p instanceof User) {
			User person1 = (User) p;
			System.out.println(JSON.toJSONString(person1));
		}
	}
}
