package com.tfl.service;

import com.tfl.pojo.User;

public interface UserService {
	boolean addUser(User user);
	boolean editUser(User user);
	User findUserById(int id);
}
