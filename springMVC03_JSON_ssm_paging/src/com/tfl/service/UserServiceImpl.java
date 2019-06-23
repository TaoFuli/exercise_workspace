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
		
		int begin =(currPage-1)*pageSize;
		
		//封装参数
		Map<String,Object> params=new HashMap<>();
		params.put("username", username);
		params.put("begin", begin);
		params.put("size", pageSize);
		
		//查询出分页数据
		List<User> data=userMapper.selectUsersByUsername(params);
		
		//总记录数
		int rowsCount=userMapper.selectUsersByUsernameCount(username);
		//总页数
		int pageCount= (int)Math.ceil((double)rowsCount/pageSize);
		
		//封装到分页对象中
		paging.setRowsCount(rowsCount);
		paging.setPageCount(pageCount);
		paging.setData(data);
		
		return paging;
	}

}
