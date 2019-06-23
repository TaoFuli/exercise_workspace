package com.tfl.mapper;

import java.util.List;

import com.tfl.pojo.User;

public interface UserMapper {
	User selectUserById(int uid);
	List<User> selectAllUsers();
}
