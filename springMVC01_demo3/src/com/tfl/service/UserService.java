package com.tfl.service;

import com.tfl.pojo.User;


public interface UserService {
	User login(String loginName,String password);
}
