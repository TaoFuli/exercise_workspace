package com.tfl.dao.impl;

import java.util.List;

import com.tfl.dao.UserDao;
import com.tfl.pojo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int insert(User user) {
		System.out.println("插入用户成功！");
		return 0;
	}

	@Override
	public int update(User user) {
		System.out.println("成功修改用户！");
		return 0;
	}

	@Override
	public int delete(int id) {
		System.out.println("删除用户成功！");
		return 0;
	}

	@Override
	public User select(int id) {
		System.out.println("查询用户");
		return null;
	}

	@Override
	public List<User> selectAll(String username) {
		System.out.println("查询所有用户成功！");
		return null;
	}

}
