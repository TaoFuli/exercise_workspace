package com.igeek.qshop.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.igeek.qshop.dao.impl.GoodsDAOImpl;
import com.igeek.qshop.pojo.Goods;

import junit.framework.TestCase;

class IGoodsDAOTest {

	
	IGoodsDAO dao = new GoodsDAOImpl();
	
	@Test
	void testAdd() throws SQLException {
		Goods goods = new Goods(-1,"xxx 上衣",100.0F,"/images/t2.jpg","xxx 流行上装",1);
		
		boolean result = dao.add(goods);
		
		TestCase.assertTrue(result);
	}

	@Test
	void testRemoveByID() {
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
	void testFindAll() throws SQLException {
		List<Goods> list = dao.findAll();
		TestCase.assertNotNull(list);
		System.out.println(list);
	}

}
