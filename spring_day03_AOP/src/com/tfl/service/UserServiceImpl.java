package com.tfl.service;

public class UserServiceImpl implements UserService {

	@Override
	public int search(int id) {
		System.out.println("查询用户操作***********");
		return 0;
	}

	@Override
	public boolean remove(int id) {
		System.out.println("删除用户操作*************");
		return false;
	}

	@Override
	public boolean edit(int id, String name) {
		System.out.println("修改用户操作**************");
		return false;
	}

}
