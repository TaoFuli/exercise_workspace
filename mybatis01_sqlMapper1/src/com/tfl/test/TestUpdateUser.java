package com.tfl.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tfl.pojo.User;

public class TestUpdateUser {
	@Test
	public void testUpdateUser() throws IOException {
		//实例化创建会话工厂
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream in=Resources.getResourceAsStream("sqlMapper_config.xml");
		SqlSessionFactory factory=builder.build(in);
		SqlSession session=factory.openSession();
		int i=session.update("com.tfl.userSpace.updateUser",new User(5,"张三","男",18));
		session.commit();
		session.rollback();
		System.out.println(i>0?"修改成功！":"修改失败！");
		session.close();
		
	}
}
