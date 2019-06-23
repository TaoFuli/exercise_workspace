package com.tfl.mapper;

import org.springframework.stereotype.Repository;

import com.tfl.pojo.User;

@Repository
public interface UserMapper {
	int insertUser(User user);
}
