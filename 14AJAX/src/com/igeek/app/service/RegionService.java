package com.igeek.app.service;

import java.sql.SQLException;

import com.igeek.app.dao.IRegionDAO;
import com.igeek.app.dao.impl.RegionDAOImpl;
import com.igeek.app.pojo.Region;

public class RegionService {

	public String findCityByName(String name)
	{
		String result = "";
		
		IRegionDAO dao = new RegionDAOImpl();
		
		try {
			Region r;
			r = dao.findCityByName(name);
			if(r==null) return "没找到";
			
			result = r.getName();
			
			if(r.getParent_id()!=0)
			{
				r = dao.findById(r.getParent_id());
				result = r.getName()+" > "+result;
			}
			
			if(r.getParent_id()!=0)
			{
				r = dao.findById(r.getParent_id());
				result = r.getName()+" > "+result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
