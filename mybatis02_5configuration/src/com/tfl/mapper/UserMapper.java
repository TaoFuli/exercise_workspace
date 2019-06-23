package com.tfl.mapper;

import java.util.List;
import java.util.Map;

import com.tfl.pojo.QueryVo;
import com.tfl.pojo.User;

public interface UserMapper {
	User selectById(int id);
	User selectByLoginNameAndPassword1(User params);
	User selectByLoginNameAndPassword2(Map<String,Object> params);
	User selectByLoginNameAndPassword3(QueryVo query);
	int selectCount();
	
	/**
	 * 	返回部分列 id,username,loginName
	 */
	User selectPart(int id);
	
	Map<String,Object> selectPart2(int id);
	
	List<Map<String,Object>> selectPart3();
	
	User selectByIdReturnResultMap(int id);
}
