package com.tfl.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tfl.pojo.User;

@Repository
public interface UserMapper {
	/**
	 * 模糊查询
	 * @param params
	 * @return
	 */
	List<User> selectUsersByUsername(Map<String,Object> params);
	/**
	 * 按照名称查询的用户数量
	 * @param username
	 * @return
	 */
	int selectUsersByUsernameCount(String username);
}
