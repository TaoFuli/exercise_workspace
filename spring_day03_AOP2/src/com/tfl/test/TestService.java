package com.tfl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfl.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:config.xml")
public class TestService {
	@Autowired
	private UserService service;
	
	@Test
	public void test1() {
		service.remove(100);
	}
	@Test
	public void test2() {
		service.search(-100);
	}
}
