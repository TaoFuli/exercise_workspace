package com.tfl.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfl.pojo.User;
import com.tfl.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_config.xml")
public class TestService {

	@Autowired
	private UserService service;
	@Test
	public void test3() {
		List<User> list=service.findByName("");
		for(User u:list) {
			System.out.println(u);
		}
	}
}
