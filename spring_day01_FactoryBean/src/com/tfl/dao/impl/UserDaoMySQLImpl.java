package com.tfl.dao.impl;

import java.util.List;

import com.tfl.dao.UserDao;
import com.tfl.pojo.User;

public class UserDaoMySQLImpl implements UserDao {

	@Override
	public int insert(User user) {
		System.out.println("insert into () value(?,?),");
		return 0;
	}

	@Override
	public int update(User user) {
		System.out.println("update t set sex='男'  where name='';");
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAll(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
