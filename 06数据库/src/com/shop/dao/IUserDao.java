package com.shop.dao;

import java.sql.SQLException;

import com.shop.domian.User;

public interface IUserDao {
	public User login(String username,String password) throws SQLException;
	public int register(User user) throws SQLException;
}
