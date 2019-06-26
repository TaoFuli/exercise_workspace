package com.igeek.igeekshop.service;

import java.sql.SQLException;

import com.igeek.igeekshop.dao.IUserDAO;
import com.igeek.igeekshop.dao.impl.UserDAOImpl;
import com.igeek.igeekshop.domain.User;

public class UserService {
	
	public User login(String username,String password)
	{
		IUserDAO dao = new UserDAOImpl();
		User user = null;
		try {
			user = dao.login(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
