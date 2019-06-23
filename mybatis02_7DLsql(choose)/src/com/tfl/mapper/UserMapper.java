package com.tfl.mapper;

import java.util.List;

import com.tfl.pojo.User;

public interface UserMapper {
	List<User> queryUserByWhere(User user);
	int updateUser(User user);
	int updateUser2(User user);
}
