package com.igeek.geekshop.dao;

import java.sql.SQLException;

import com.igeek.geekshop.domain.User;

public interface IUserDAO 
{
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password) throws SQLException; 

}
