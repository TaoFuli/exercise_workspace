package com.shop.dao;

import java.sql.SQLException;

import org.junit.Test;

import com.shop.dao.Impl.UserDaoImpl;
import com.shop.domian.User;

import junit.framework.TestCase;

class IUserDaoTest {
	@Test
	void testLogin()
	{
		IUserDao userDao=new UserDaoImpl();
		User user;
		try {
			user = userDao.login("admin", "123");
			TestCase.assertNotNull(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	void testCount()
	{
		int i=foo();
		TestCase.assertEquals(2, i);
		//TestCase.assertEquals(期望值，实际计算得到的值)；
		//如果期望值==实际值 测试通过，显示绿色
		//否则  测试JUnit不通过，下面显示红色
	}
	int foo()
	{
		return 1;
	}
}
