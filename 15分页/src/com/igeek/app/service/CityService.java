package com.igeek.app.service;

import java.sql.SQLException;
import java.util.List;

import com.igeek.app.dao.ICityDAO;
import com.igeek.app.dao.ICountryDAO;
import com.igeek.app.dao.impl.CityDAOImpl;
import com.igeek.app.dao.impl.CountryDAOImpl;
import com.igeek.app.pojo.City;
import com.igeek.app.pojo.Country;
import com.igeek.app.pojo.PageBean;

public class CityService 
{
	
	public PageBean<City> findCityByPage(int page) 
	{
		// 每页数量
		int countPerPage = 10;
		
		ICityDAO dao = new CityDAOImpl();
		
		// 国家总数
		long count = 0;
		try {
			count = dao.getCityCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 计算总页数
		int pageAllCount = (int) count / countPerPage;
		
		if(page<1) page=1;
		if(page>pageAllCount) page=pageAllCount;
		
		List<City> list = null;
		try {
			list = dao.findCity((page - 1) * countPerPage, countPerPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		// 计算范围
		int start = (page-1)/countPerPage*countPerPage+1;
		int end = start+9;	
		if(end>countPerPage) end=countPerPage;
		
		// 	
		PageBean<City> bean = new PageBean(list,page,pageAllCount,countPerPage,start,end);
		
		return bean;
	}
	
	public PageBean<City> findCountryCityByPage(String code,int page) 
	{
		// 每页数量
		int countPerPage = 10;
		
		ICityDAO dao = new CityDAOImpl();
		
		// 国家总数
		long count = 0;
		try {
			count = dao.getCityCountByCountryCode(code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 计算总页数
		int pageAllCount = (int) count / countPerPage;
		
		if(page<1) page=1;
		if(page>pageAllCount) page=pageAllCount;
		
		List<City> list = null;
		try {
			list = dao.findCityByCountryCode(code,(page - 1) * countPerPage, countPerPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		// 计算范围
		int start = (page-1)/countPerPage*countPerPage+1;
		int end = start+9;	
		if(end>countPerPage) end=countPerPage;
		
		// 	
		PageBean<City> bean = new PageBean(list,page,pageAllCount,countPerPage,start,end);
		
		return bean;
	}

}
