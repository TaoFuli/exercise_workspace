package com.tfl.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tfl.pojo.User;

@Repository
public interface UserMapper {
	User selectUserById(int id);
	List<User> selectAllUsers();
	User selectUsersByLoginNameAndPassword(Map<String,Object> params);
}
