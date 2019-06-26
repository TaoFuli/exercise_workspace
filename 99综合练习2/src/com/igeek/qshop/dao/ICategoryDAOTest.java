package com.igeek.qshop.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.igeek.qshop.dao.impl.CategoryDAOImpl;
import com.igeek.qshop.pojo.Category;

import junit.framework.TestCase;

class ICategoryDAOTest {

	ICategoryDAO dao = new CategoryDAOImpl();
	
	@Test
	void testAdd() throws SQLException {
		boolean result = dao.add("女装");
		TestCase.assertTrue(result);
	}

	@Test
	void testRemoveByID() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveByName() {
		fail("Not yet implemented");
	}

	@Test
	void testModify() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByID() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() throws SQLException {
		List<Category> list = dao.findAll();
		TestCase.assertNotNull(list);
		System.out.println(list);
	}

}
