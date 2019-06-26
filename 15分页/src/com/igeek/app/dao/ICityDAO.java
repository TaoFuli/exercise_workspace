package com.igeek.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.igeek.app.pojo.City;

public interface ICityDAO 
{
	/**
	 * 查询指定范围的国家
	 * @param start	开始的序号
	 * @param count 查询的数量
	 * @return
	 * @throws SQLException
	 */
	public List<City> findCity(int start,int count) throws SQLException;
	
	public List<City> findCityByCountryCode(String code,int start,int count) throws SQLException;

	
	/**
	 * 查询国家数量
	 * @return
	 */
	public long getCityCount() throws SQLException;
	
	public long getCityCountByCountryCode(String code) throws SQLException; 

}
