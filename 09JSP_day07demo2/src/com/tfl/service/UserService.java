package com.tfl.service;

import java.util.List;

import com.tfl.pojo.User;

/**
 * 业务接口 
 */
public interface UserService {
	User  findById(int id);
	List<User>  findByName(String name);
	boolean  edit(User user);
	boolean  removeById(int id);
}
