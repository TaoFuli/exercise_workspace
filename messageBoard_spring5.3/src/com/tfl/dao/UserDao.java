package com.tfl.dao;

import com.tfl.pojo.User;

public interface UserDao {
	
	/** 按照Id查询 */
	User  selectById(int id) throws Exception;
	
	/** 按照登录名和密码查询 */
	User  selectByLoginNameAndPassword(String loginName,String password) throws Exception;

	/** 插入新用户 */
	int  insertUser(User user) throws Exception;

}
