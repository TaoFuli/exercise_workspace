package com.tfl.service;

import com.tfl.pojo.Paging;
import com.tfl.pojo.User;

public interface UserService {
	/**
	 * 按照  当前页和每页显示数据  分页查询数据  返回分页对象
	 * @param username	模糊查询的关键字
	 * @param currPage	当前页
	 * @param pageSize	页面大小
	 * @return	返回分页查询数据
	 */
	Paging<User> search(String username,int currPage,int pageSize);
	
}
