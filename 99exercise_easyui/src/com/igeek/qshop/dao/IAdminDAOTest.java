package com.igeek.qshop.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.igeek.qshop.dao.impl.AdminDAOImpl;
import com.igeek.qshop.pojo.Admin;

import junit.framework.TestCase;

class IAdminDAOTest {

	IAdminDAO dao = new AdminDAOImpl();
	
	@Test
	void testLogin() throws SQLException 
	{
		Admin admin = dao.login("qiang", "123456");
		TestCase.assertNotNull(admin);
		System.out.println(admin);
	}

	@Test
	void testModifyPassword() throws SQLException {
		boolean result = dao.modifyPassword("qiang", "654321");
		TestCase.assertTrue(result);
	}

}
