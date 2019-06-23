package com.tfl.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestDeleteById {
	@Test
	public void testDeleteById() throws IOException {
		//实例化会话工厂创建
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream in=Resources.getResourceAsStream("sqlMapper_config.xml");
		SqlSessionFactory factory=builder.build(in);
		//开启会话
		SqlSession session=factory.openSession();
		int i=session.delete("com.tfl.userSpace.deleteUser",1);
		session.commit();//提交
		session.rollback();
		System.out.println(i>0?"删除成功！":"删除失败！");
		session.close();
		
	}
	
}
