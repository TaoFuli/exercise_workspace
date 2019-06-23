package com.tfl.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tfl.pojo.User;

public class TestInsertUser {
	@Test
	public void testInsertUser() throws IOException {
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		InputStream in=Resources.getResourceAsStream("sqlMapper_config.xml");
		SqlSessionFactory factory=builder.build(in);
		//开启会话
		SqlSession session=factory.openSession();
		int i=session.insert("com.tfl.userSpace.insertUser",new User("贾六","男",22));
		session.commit();//提交
//		session.rollback();
		System.out.println(i>0?"插入成功！":"插入失败！");
		//关闭
		session.close();
		
	}
}
