package com.igeek.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.igeek.app.dao.impl.CountryDAOImpl;
import com.igeek.app.pojo.Country;

import junit.framework.TestCase;

class ICountryDAOTest {

	@Test
	void testFindAll() throws SQLException {
		ICountryDAO dao = new CountryDAOImpl();
		List<Country> list = dao.findAll();
		TestCase.assertNotNull(list);
		for(Country c:list)
		{
			System.out.println(c);
		}
	}

}
