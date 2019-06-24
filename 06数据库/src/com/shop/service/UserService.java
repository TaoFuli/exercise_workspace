package com.shop.service;

import java.sql.SQLException;

import com.shop.dao.IUserDao;
import com.shop.dao.Impl.UserDaoImpl;
import com.shop.domian.User;

public class UserService {
	public User login(String username,String password)
	{
		IUserDao userDao=new UserDaoImpl();
		User user=null;
		try {
			user=userDao.login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public boolean register(User user)
	{
		IUserDao userDao=new UserDaoImpl();
		try {
			return userDao.register(user)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
