package com.tfl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfl.dao.UserDao;
import com.tfl.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	@Override
	public User findById(int id) {
		return dao.select(id);
	}

	@Override
	public List<User> findByName(String name) {
		return dao.select(name);
	}

	@Override
	public boolean editUser(User user) {
		return dao.insert(user)>0;
	}

	@Override
	public boolean delUserById(int id) {
		return dao.delete(id)>0;
	}

}
