package com.tfl.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tfl.mapper.UserMapper;
import com.tfl.pojo.QueryVo;
import com.tfl.pojo.User;

public class TestMapper {

	private SqlSessionFactory factory;
	
	@Before
	public void before() throws IOException {
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		factory=builder.build(Resources.getResourceAsStream("sqlMapperConfig.xml"),"development1");
	}
	@Test
	public void selectById() {
		SqlSession session=factory.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
		User user=mapper.selectById(1);
		System.out.println(user);
	}
	/**
	 * 测试多个参数
	 */
	@Test
	public void selectByLoginNameAndPassword1() {
		SqlSession session =factory.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
		User user=mapper.selectByLoginNameAndPassword1(new User("lisi","123"));
		System.out.println(user);
	}
	@Test
	public void selectByLoginNameAndPassword2() {
		SqlSession session=factory.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
		Map<String,Object> params=new HashMap<>();
		params.put("loginName", "san");
		params.put("password", "123");
		User user=mapper.selectByLoginNameAndPassword2(params);
		System.out.println(user);
	}
	@Test
	public void selectByLoginNameAndPassword3() {
		SqlSession session=factory.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
		QueryVo query=new QueryVo(new User("wangwu","123"));
		User user=mapper.selectByLoginNameAndPassword3(query);
		System.out.println(user);
	}
	@Test
	public void selectCount() {
		SqlSession session=factory.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
		int c=mapper.selectCount();
		Assert.assertTrue(c>0);
	}
	@Test
	public void selectPart() {
		SqlSession session=factory.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
		User user=mapper.selectPart(1);
		System.out.println(user);
	}
	@Test
	public void selectPart2() {
		SqlSession session =factory.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
		Map<String,Object> user=mapper.selectPart2(1);
		System.out.println(user);
	}
	@Test
	public void selectPart3() {
		SqlSession session=factory.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
		List<Map<String,Object>> users=mapper.selectPart3();
		for(Map<String,Object> map:users) {
			System.out.println(map);
		}
	}
	@Test
	public void selectByIdReturnResultMap() {
		SqlSession session=factory.openSession();
		UserMapper mapper=session.getMapper(UserMapper.class);
		User user=mapper.selectByIdReturnResultMap(2);
		System.out.println(user);
	}
}
