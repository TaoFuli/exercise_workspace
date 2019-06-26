package com.igeek.igeekshop.dao;

import java.sql.SQLException;

import com.igeek.igeekshop.domain.User;

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
