package com.tfl.service.impl;

import com.tfl.dao.UserDao;
import com.tfl.dao.impl.UserDaoImpl;
import com.tfl.dao.impl.UserDaoMySQLImpl;
import com.tfl.pojo.User;
import com.tfl.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao dao) {
		this.userDao = dao;
	}
	
	public UserServiceImpl() {
		userDao=new UserDaoImpl();
		userDao=new UserDaoMySQLImpl();
	}

	@Override
	public boolean addUser(User user) {
		return userDao.insert(user)>0;
	}

	@Override
	public boolean editUser(User user) {
		return userDao.insert(user)>0;
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
