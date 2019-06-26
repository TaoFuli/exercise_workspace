package com.igeek.igeekshop.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.igeek.igeekshop.dao.IUserDAO;
import com.igeek.igeekshop.domain.User;
import com.igeek.utils.JDBCUtils;

public class UserDAOImpl implements IUserDAO{

	@Override
	public User login(String username, String password) throws SQLException 
	{
		// 
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?;";
		Object[] params = {username,password};
		User user = runner.query(sql,new BeanHandler<>(User.class),params);
		return user;
	}

}
