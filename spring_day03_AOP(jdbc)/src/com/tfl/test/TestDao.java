package com.tfl.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfl.dao.UserDao;
import com.tfl.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_config.xml")
public class TestDao {
	
	@Autowired
	private UserDao dao;
	
	public void testSimpleDriverDataSource() {
//		SimpleDriverDataSource ds=null;
//		ds.setDriver(com.mysql.jdbc.Driver);
//		ds.setUrl(url);
//		ds.setUsername(username);
//		ds.setPassword(password);
//		JdbcTemplate jdbcTemplate;
//		jdbcTemplate.setDataSource(dataSource);
	}
	public void test2() {
		User u=dao.select(101);
		System.out.println(u);
	}
	@Test
	public void test3() {
		List<User> list=dao.select("");
		for(User u:list) {
			System.out.println(u);
		}
	}
}
