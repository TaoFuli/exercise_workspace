package com.igeek.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.igeek.app.dao.impl.RegionDAOImpl;
import com.igeek.app.pojo.Region;

import junit.framework.TestCase;

class IRegionDAOTest {

	@Test
	void testFindAllByParentId() throws SQLException {
	
		IRegionDAO dao = new RegionDAOImpl();
		List<Region> result = dao.findAllByParentId(320000);
		
		TestCase.assertNotNull(result);
		for(Region r:result)
		{
			System.out.println(r);
		}
	}

}
