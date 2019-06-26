package com.igeek.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.igeek.app.dao.impl.CityDAOImpl;
import com.igeek.app.dao.impl.CountryDAOImpl;
import com.igeek.app.pojo.City;
import com.igeek.app.pojo.Country;

import junit.framework.TestCase;

class ICountryDAOTest {


	
	@Test
	void testFind() throws SQLException {
		ICityDAO dao = new CityDAOImpl();
		List<City> list = dao.findCity(10, 10);
		TestCase.assertNotNull(list);
		for(City c:list)
		{
			System.out.println(c);
		}
	}
	
	@Test
	void testGetCount() throws SQLException
	{
		ICityDAO dao = new CityDAOImpl();
		long count = dao.getCityCount();
		System.out.println(count);
		TestCase.assertNotNull(count>0);
	}

}
