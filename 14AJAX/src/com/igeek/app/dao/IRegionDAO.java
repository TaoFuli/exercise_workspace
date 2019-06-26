package com.igeek.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.igeek.app.pojo.Region;

public interface IRegionDAO 
{
	
	public Region findById(int id) throws SQLException;
	
	public List<Region> findAllByParentId(int parent_id) throws SQLException;
	
	public List<Region> findAllByName(String name) throws SQLException;

	public Region findCityByName(String name) throws SQLException;
}
