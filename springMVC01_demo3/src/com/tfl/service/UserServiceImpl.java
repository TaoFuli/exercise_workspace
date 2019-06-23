package com.tfl.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfl.mapper.UserMapper;
import com.tfl.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(String loginName, String password) {
		Map<String,Object> params=new HashMap<>();
		params.put("loginName", loginName);
		params.put("password", password);
		return userMapper.selectUsersByLoginNameAndPassword(params);
	}

}
