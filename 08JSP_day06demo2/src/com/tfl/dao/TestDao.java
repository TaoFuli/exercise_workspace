package com.tfl.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.tfl.pojo.User;



public class TestDao {

	@Test
	public void login() {
		UserDao dao = new UserDaoImpl();
		
		User user = dao.selectByLoginNameAndPassword("admin", "admin");
		
		System.out.println(user);
		
	}
	
	@Test
	public void select() {
		UserDao dao = new UserDaoImpl();
		
		List<User> users = dao.selectByUserName("d");
		
		for (User user : users) {
			System.out.println(user);
		}
		
	}
	
}
