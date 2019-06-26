package com.igeek.igeekshop.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.igeek.igeekshop.dao.impl.UserDAOImpl;
import com.igeek.igeekshop.domain.User;

import junit.framework.TestCase;

class IUserDAOTest {

	@Test
	void testLogin() throws SQLException {
		
		IUserDAO dao = new UserDAOImpl();
		User user = dao.login("tom", "123");		
		TestCase.assertNotNull(user);
		System.out.println(user);
	}

}
