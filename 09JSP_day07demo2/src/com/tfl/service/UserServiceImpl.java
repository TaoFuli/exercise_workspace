package com.tfl.service;

import java.util.List;

import com.tfl.dao.UserDao;
import com.tfl.dao.UserDaoImpl;
import com.tfl.pojo.User;

/**
 * 业务接口实现类
 */
public class UserServiceImpl implements UserService {

	//依赖UserDao
	private UserDao  userDao = null;
	
	/**
	 * 构造方法
	 */
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	
	
	@Override
	public User findById(int id) {
		try {
			return userDao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 按照名称查询
	 */
	@Override
	public List<User> findByName(String name) {
		try {
			return userDao.selectByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean edit(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
