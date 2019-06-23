package com.tfl.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfl.pojo.Paging;
import com.tfl.pojo.User;
import com.tfl.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class TestService {
	
	@Autowired
	private UserService service;
	
	@Test
	public void testSearch() {
		Paging<User> paging=service.search("",1,5);
		System.out.println(paging);
		List<User> a = paging.getData();
		for (User user : a) {
			System.out.println(user.getBirthday());
			System.out.println(user);
		}
		
	}

}
