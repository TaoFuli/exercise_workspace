package com.igeek.qshop.dao;

import java.sql.SQLException;

import com.igeek.qshop.pojo.Admin;


public interface IAdminDAO {

	/**
	 * 管理员登录
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Admin login(String username,String password) throws SQLException;
	
	/**
	 * 管理员修改密码
	 * @param username
	 * @param newPassword
	 * @return
	 * @throws SQLException
	 */
	public boolean modifyPassword(String username,String newPassword) throws SQLException;
	
}
