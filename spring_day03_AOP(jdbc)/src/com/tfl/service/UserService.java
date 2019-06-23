package com.tfl.service;

import java.util.List;

import com.tfl.pojo.User;

public interface UserService {
	public User findById(int id);
	public List<User> findByName(String name);
	public boolean editUser(User user);
	public boolean delUserById(int id);
}
