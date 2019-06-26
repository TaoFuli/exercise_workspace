package com.igeek.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.igeek.app.pojo.Country;

public interface ICountryDAO 
{
	/**
	 * 返回所有国家的信息列表
	 * @return
	 * @throws SQLException
	 */
	public List<Country> findAll() throws SQLException;
	
	/**
	 * 查询指定范围的国家
	 * @param start	开始的序号
	 * @param count 查询的数量
	 * @return
	 * @throws SQLException
	 */
	public List<Country> findCountry(int start,int count) throws SQLException;
	
	/**
	 * 查询国家数量
	 * @return
	 */
	public long getCountryCount() throws SQLException;
}
