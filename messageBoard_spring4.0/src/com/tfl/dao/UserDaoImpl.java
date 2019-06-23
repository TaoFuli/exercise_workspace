package com.tfl.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tfl.pojo.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	//依赖DButils
	@Autowired
	private QueryRunner qr ;
	
	
	
	@Override
	public User selectByLoginNameAndPassword(String loginName, String password) throws Exception {
		String sql = "SELECT * FROM users WHERE loginName = ? AND `password`=PASSWORD(?)";
		Object [] params = {loginName,password};
		
		return qr.query(sql, new BeanHandler<User>(User.class),params);
	}

	@Override
	public int insertUser(User user) throws Exception {
		String sql = "INSERT INTO users(username,loginname,`password`,email,writerName)  " + 
				"VALUES(?,?,PASSWORD(?),?,?)";
		
		Object [] params = {user.getUsername(),user.getLoginName(),
				user.getPassword(),user.getEmail(),user.getWriterName()};
		
		return qr.update(sql, params);
	}

	/**
	 * 按照Id查找 用户
	 */
	@Override
	public User selectById(int id) throws Exception {
		String sql = "SELECT * FROM users WHERE id = ?";
		Object [] params = {id};
		
		return qr.query(sql, new BeanHandler<User>(User.class),params);
	}

}
