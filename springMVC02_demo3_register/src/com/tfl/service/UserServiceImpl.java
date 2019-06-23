package com.tfl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tfl.mapper.UserMapper;
import com.tfl.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public boolean addUser(User user) {
		int lastId=userMapper.insertUser(user);
		System.out.println("lastId="+lastId);
		return lastId>0;
	}

}
