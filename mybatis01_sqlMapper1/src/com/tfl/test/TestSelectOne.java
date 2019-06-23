package com.tfl.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tfl.pojo.User;

public class TestSelectOne {
	
	@Test
	public void testSelectOne() throws IOException {
		//实例化创建会话工厂
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream in=Resources.getResourceAsStream("sqlMapper_config.xml");
		SqlSessionFactory factory=builder.build(in);
		//开启会话
		SqlSession session=factory.openSession();
		User u=(User)session.selectOne("com.tfl.userSpace.selectById",5);
		System.out.println(u);
		session.close();
	}
}
