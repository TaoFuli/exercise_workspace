package com.tfl.dao;

import java.util.List;

import com.tfl.pojo.User;

public interface UserDao {
	/**
	 * 插入数据
	 * @param user
	 * @return
	 */
	int insert(User user);
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	int delete(int id);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int update(User user);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	User select(int id);
	/**
	 * 	根据姓名模糊查询
	 * @param name
	 * @return
	 */
	List<User> select(String name);
}
