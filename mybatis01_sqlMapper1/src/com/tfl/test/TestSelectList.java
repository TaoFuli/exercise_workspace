package com.tfl.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tfl.pojo.User;

public class TestSelectList {
	@Test
	public void selectList() throws IOException {
		//实例化会话工厂创建
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream in=Resources.getResourceAsStream("sqlMapper_config.xml");
		SqlSessionFactory factory=builder.build(in);
		//开启会话
		SqlSession session=factory.openSession();
		List<User> list=session.selectList("com.tfl.userSpace.selectAll");
		
		for(User user:list) {
			System.out.println(user);
		}
		session.close();
	}
}
