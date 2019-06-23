package com.tfl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfl.pojo.User;
import com.tfl.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_*.xml")
public class TestUserService {

		@Autowired
		private UserService service;
		@Test
		public void test() {
			boolean b=service.addUser(new User("王五","wangwu","wangwu","男","2018-11-22","WANG@wu.com"));
			System.out.println(b);
		}
}
