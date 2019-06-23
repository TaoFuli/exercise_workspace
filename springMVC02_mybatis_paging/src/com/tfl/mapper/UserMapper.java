package com.tfl.mapper;

import java.util.List;
import java.util.Map;

import com.tfl.pojo.User;

public interface UserMapper {
	List<User> selectUsersByUsername(Map<String,Object> params);
	int selectUsersByUsernameCount(String username);
}
