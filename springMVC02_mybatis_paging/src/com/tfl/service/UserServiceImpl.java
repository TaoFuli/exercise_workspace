package com.tfl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfl.mapper.UserMapper;
import com.tfl.pojo.Paging;
import com.tfl.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Paging<User> search(String username, int currPage, int pageSize) {
		Paging<User> paging=new Paging<>(currPage,pageSize);
		
		int begin=(currPage-1)*pageSize;
		
		Map<String,Object> params=new HashMap<>();
		params.put("username", username);
		params.put("begin", begin);
		params.put("size", pageSize);
		
		List<User> data=userMapper.selectUsersByUsername(params);
		int rowsCount=userMapper.selectUsersByUsernameCount(username);
		int pageCount=(int)Math.ceil((double)rowsCount/pageSize);
		paging.setRowsCount(rowsCount);
		paging.setPageCount(pageCount);
		paging.setData(data);
		return paging;
	}

}
