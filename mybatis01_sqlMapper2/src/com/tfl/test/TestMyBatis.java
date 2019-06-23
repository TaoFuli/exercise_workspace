package com.tfl.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.tfl.pojo.User;

public class TestMyBatis {
	//会话工厂
	private SqlSessionFactory factory;
	
	@Before
	public void before() throws IOException {
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		factory=builder.build(Resources.getResourceAsStream("sqlMapperConfig.xml"));
	}
	@Test
	public void selectById() {
		SqlSession session=factory.openSession();
		User user=(User)session.selectOne("selectById",2);
		System.out.println(user);
		session.close();
	}
	@Test
	public void all() {
		SqlSession session=factory.openSession();
		List<User> userlist=session.selectList("com.tfl.userspace.selectAll");
		for(User u:userlist) {
			System.out.println(u);
		}
		session.close();
	}
	@Test
	public void selectByName() {
		SqlSession session=factory.openSession();
		List<User> userlist=session.selectList("com.tfl.userspace.selectByName","%test%");
		for(User u:userlist) {
			System.out.println(u);
		}
		session.close();
	}
	@Test
	public void selectByName2() {
		SqlSession session=factory.openSession();
		List<User> userlist=session.selectList("com.tfl.userspace.selectByName2","test");
		for(User u:userlist) {
			System.out.println(u);
		}
		session.close();
	}
	/**
	 * 	多条件查询
	 */
	@Test
	public void select1() {
		SqlSession session=factory.openSession();
		User user=new User();
		user.setSex("女");
		user.setAge(22);
		
		List<User> userlist=session.selectList("com.tfl.userspace.select1",user);
		for(User u:userlist) {
			System.out.println(u);
		}
		session.close();
	}
	
	/**
	 * 	多条件查询  	Map作为参数传递
	 */
	@Test
	public void select2() {
		SqlSession session=factory.openSession();
		Map<String,Object> params=new HashMap<>();
		params.put("param_sex", "男");
		params.put("param_age", 22);
		
		List<User> userlist=session.selectList("com.tfl.userspace.select2",params);
		for(User u:userlist) {
			System.out.println(u);
		}
		session.close();
	}
	
}
