package com.tfl.dao;

import java.util.List;

import com.tfl.pojo.User;

/**
 * 用户的数据访问接口 
 */
public interface UserDao {
	int  insert(User user) throws Exception;
	int  update(User user) throws Exception;
	int  delete(int id) throws Exception;
	User  selectById(int id)   throws Exception;
	List<User>  selectByName(String name)  throws Exception;
}
