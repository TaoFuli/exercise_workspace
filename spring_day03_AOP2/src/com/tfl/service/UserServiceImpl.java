package com.tfl.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public int search(int id) {
		System.out.println("查询用户*****");
		if(id<0) 
			throw new RuntimeException("ID不能小于0");
		return 888;
	}

	@Override
	public boolean remove(int id) {
		System.out.println("删除用户****************");
		return false;
	}
	@Override
	public boolean edit(int id,String name) {
		System.out.println("修改用户***********");
		return false;
	}

}
