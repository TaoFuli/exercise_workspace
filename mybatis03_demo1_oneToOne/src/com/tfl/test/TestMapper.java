package com.tfl.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.tfl.mapper.OrderMapper;
import com.tfl.mapper.UserMapper;
import com.tfl.pojo.OrderUser;
import com.tfl.pojo.User;

public class TestMapper {
	private SqlSession session;
	private OrderMapper om;
	private UserMapper um;
	@Before
	public void before() throws IOException {
		session=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
		om=session.getMapper(OrderMapper.class);
		um=session.getMapper(UserMapper.class);
	}
	@Test
	public void testSelectOrderById() {
		OrderUser o=om.selectOrderById(1010);
		System.out.println(o);
	}
	@Test
	public void testSelectUserrById() {
		User u=um.selectUserById(1002)
		System.out.println(u);
	}
}
