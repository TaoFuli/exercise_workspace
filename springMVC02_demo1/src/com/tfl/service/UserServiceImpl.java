package com.tfl.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public boolean login(String name, String pwd) {
		return "geek".equalsIgnoreCase(name)&&"123".equals(pwd);
	}

}
