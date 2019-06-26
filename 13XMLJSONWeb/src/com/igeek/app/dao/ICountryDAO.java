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

}
