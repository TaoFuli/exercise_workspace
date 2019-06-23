package com.tfl.mapper;

import java.util.List;

import com.tfl.pojo.QueryVo;
import com.tfl.pojo.User;

public interface UserMapper {
	List<User> queryUserByWhere(User user);
	List<User> queryUserByWhere2(User user);
	List<User> queryUserByIds(QueryVo<?> query);
	int insertList(QueryVo<?> query);
}
