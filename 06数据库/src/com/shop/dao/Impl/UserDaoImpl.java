package com.shop.dao.Impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.shop.dao.IUserDao;
import com.shop.domian.User;
import com.shop.utils.C3p0Utils;

public class UserDaoImpl implements IUserDao{
	public User login(String username,String password) throws SQLException
	{
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from user where username=? and password=?;";
		User user=runner.query(sql, new BeanHandler<>(User.class),username,password);
		return user;
	}
	public int register(User user) throws SQLException
	{
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="INSERT INTO USER(username,password,email) VALUES(?,?,?);";
		Object[] params= {user.getUsername(),user.getPassword(),user.getEmail()};
		return runner.update(sql,params);
	}
}
