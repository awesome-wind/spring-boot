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

import java.util.List;

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
//		user.setSex("nan");
//		user.setAge(10);
//		userMapper.addOne(user);
//
//		Assert.assertNotNull(user.getId());
//		logger.debug(JSON.toJSONString(user));
//	}

	@Test
	public void testFindAll() {
		List<User> users = userMapper.findAll();

		Assert.assertNotNull(users);
		logger.debug(JSON.toJSONString(users));
	}


	// 测试mybatis缓存
	@Test
	public void testCache() {
		long begin = System.currentTimeMillis();
		List<User> persons = userMapper.findAll();
		long end1 = System.currentTimeMillis();
		userMapper.findAll();
		long end2 = System.currentTimeMillis();
		userMapper.findAll();
		long end3 = System.currentTimeMillis();
		userMapper.findAll();
		long end4 = System.currentTimeMillis();
		userMapper.findAll();
		long end5 = System.currentTimeMillis();
		userMapper.findAll();
		long end6 = System.currentTimeMillis();
		userMapper.findAll();
		long end7 = System.currentTimeMillis();
		logger.debug("第一次请求时间：" + (end1 - begin) + "ms");
		logger.debug("第二次请求时间:" + (end2 - end1) + "ms");
		logger.debug("第三次请求时间:" + (end3 - end2) + "ms");
		logger.debug("第四次请求时间:" + (end4 - end3) + "ms");
		logger.debug("第5次请求时间:" + (end5 - end4) + "ms");
		logger.debug("第6次请求时间:" + (end6 - end5) + "ms");
		logger.debug("第7次请求时间:" + (end7 - end6) + "ms");


//		Assert.assertNotNull(persons);
		logger.debug(JSON.toJSONString(persons));
	}

	// 测试Redis存储和获取一个List
//	@Test
//	public void testRedisCacheSetList() {
//		List<Person> persons = new ArrayList<>();
//		persons.add(person);
//		persons.add(person);
//		persons.add(person);
//		redisTemplate.opsForValue().set(person.getId() + "", persons, 2, TimeUnit.MINUTES);
//		persons = (List<Person>) redisTemplate.opsForValue().get(person.getId() + "");
//		System.out.println(JSON.toJSONString(persons));
//	}
//
//	// 测试Redis存储和获取一个Object
//	@Test
//	public void testRedisCacheSetObject() {
//		redisTemplate.opsForValue().set(person.getId() + "", person, 2, TimeUnit.MINUTES);
//		Object p = redisTemplate.opsForValue().get(person.getId() + "");
//		if (p instanceof Person) {
//			Person person1 = (Person) p;
//			System.out.println(JSON.toJSONString(person1));
//		}
//	}
//
//	// 测试 通过Spring Aware获取Spring容器中的额Bean
//	@Test
//	public void testApplicationContextAware() {
//		RedisTemplate redisTemplate = SpringContextHolder.getBean("redisTemplate");
//		System.out.println(redisTemplate);
//	}

}
