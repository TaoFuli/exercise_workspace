package com.tfl.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tfl.pojo.User;
import com.tfl.utils.C3P0Utils;

/**
 * Dao的实现类
 */
public class UserDaoImpl implements UserDao {
	
	//dbutils工具
	private  QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	

	/**
	 * 插入
	 */
	@Override
	public int insert(User user) throws Exception {
		String sql = "INSERT INTO users(username,loginName,PASSWORD,email) VALUES(?,?,PASSWORD(?),?); ";
		Object [] params = {user.getUsername(),user.getLoginName(),user.getPassword(),user.getEmail()};
		return qr.update(sql, params);
	}

	/**
	 * 更新
	 */
	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 删除
	 */
	@Override
	public int delete(int id) throws Exception {
		return 0;
	}

	/**
	 * 查询
	 */
	@Override
	public User selectById(int id) throws Exception {
		String sql = "select * from users where id = ?";
		Object [] params = {id};
		BeanHandler<User> handler = new BeanHandler<>(User.class);
		User u = qr.query(sql, handler,params);
		return u;
	}

	/**
	 * 按照用户名 模糊查询
	 */
	@Override
	public List<User> selectByName(String name) throws Exception {
		String sql = "select * from users where username like ?";
		Object [] params = {"%"+name+"%"};
		BeanListHandler<User> handler = new BeanListHandler<>(User.class);
		List<User> list = qr.query(sql, handler,params);
		return list;
	}

}
