package com.tfl.dao;

import java.util.List;

import com.tfl.pojo.User;

public interface UserDao {
	/**
	 * 插入用户
	 * */
	int insert(User user);
	/*更新用户*/
	int update(User user);
	/*删除用户*/
	int delete(int id);
	/*查询用户*/
	User select(int id);
	/*查询所有用户*/
	List<User> selectAll(String username);
}
