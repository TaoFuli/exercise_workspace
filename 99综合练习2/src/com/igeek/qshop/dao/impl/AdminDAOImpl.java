package com.igeek.qshop.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.igeek.qshop.dao.IAdminDAO;
import com.igeek.qshop.pojo.Admin;
import com.igeek.utils.JDBCUtils;

public class AdminDAOImpl implements IAdminDAO{

	@Override
	public Admin login(String username, String password) throws SQLException 
	{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from admin where username = ? and password = md5(?);";
		Object[] params = {username,password};
		Admin user = runner.query(sql,new BeanHandler<>(Admin.class),params);
		return user;
	}
	
	@Override
	public boolean modifyPassword(String username, String newPassword) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update admin set password=md5(?) where username = ?;";
		Object[] params = {newPassword,username};
		int result = runner.update(sql,params);
		return result>0;
	}
}
