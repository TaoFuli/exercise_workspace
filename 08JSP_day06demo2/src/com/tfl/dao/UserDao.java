package com.tfl.dao;

import java.util.List;

import com.tfl.pojo.User;

public interface UserDao {
	User selectByLoginNameAndPassword(String loginName,String password);
	List<User> selectByUserName(String username);
	int insertByUser(User user);
	int removeByLoginName(User user);
}
