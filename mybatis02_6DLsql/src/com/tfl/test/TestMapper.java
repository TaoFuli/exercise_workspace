package com.tfl.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.tfl.mapper.UserMapper;
import com.tfl.pojo.QueryVo;
import com.tfl.pojo.User;

public class TestMapper {
	private UserMapper mapper;
	private SqlSession session;
	
	@Before
	public void before() throws IOException {
		session=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapperConfig.xml")).openSession();
		mapper=session.getMapper(UserMapper.class);
	}
	@Test
	public void queryUserByWhere() {
		User userParams=new User();
		List<User> users=mapper.queryUserByWhere(userParams);
		for(User user:users) {
			System.out.println(user);
		}
	}
	@Test
	public void queryUserByWhere2() {
		User user=new User();
		List<User> users=mapper.queryUserByWhere2(user);
		for(User u:users) {
			System.out.println(u);
		}
	}
	@Test
	public void queryUserByIds() {
		List<Integer> params=new ArrayList<Integer>();
		params.add(1);
		params.add(11);
		params.add(12);
		
		QueryVo<Integer> query=new QueryVo<Integer>(params);
		List<User> users=mapper.queryUserByIds(query);
		for(User u:users) {
			System.out.println(u);
		}
	}
	/**
	 * 测试批量插入
	 */
	@Test
	public void insertList() {
		List<User> params=new ArrayList<>();
		params.add(new User("王五","wangwu","wangwu","女",new Date(),"wang@qq.com"));
		params.add(new User("贾六","jialiu","jialiu","女",new Date(),"liu@qq.com"));
		params.add(new User("赵六","zhaoliu","zhaoliu","女",new Date(),"jia@qq.com"));
		params.add(new User("田七","tianqi","wangwu","女",new Date(),"wang@qq.com"));
		params.add(new User("牛二","niuer","niuer","女",new Date(),"jialiu@qq.com"));
		
		QueryVo<User> query=new QueryVo<User>();
		query.setIds(params);;
		//执行
		int i=mapper.insertList(query);
		System.out.println(i);
		session.commit();
		
	}
}
