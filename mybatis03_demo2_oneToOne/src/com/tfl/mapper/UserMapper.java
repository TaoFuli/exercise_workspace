package com.tfl.mapper;

import com.tfl.pojo.User;

public interface UserMapper {
	User selectUserById(int uid);
	List<User> selectAllUsers()
}
