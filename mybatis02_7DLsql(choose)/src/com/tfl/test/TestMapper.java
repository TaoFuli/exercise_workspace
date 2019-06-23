package com.tfl.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.tfl.mapper.UserMapper;
import com.tfl.pojo.User;

public class TestMapper {
	private UserMapper mapper;
	private SqlSession session;
	@Before
	public void before() throws IOException {
		session=new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
		mapper=session.getMapper(UserMapper.class);
	}
	@Test
	public void queryUserByWhere() {
		User userParams=new User();
//		userParams.setSex("男");
		userParams.setUsername("张");
		List<User> users=mapper.queryUserByWhere(userParams);
		for(User user:users) {
			System.out.println(user);
		}
	}
}
