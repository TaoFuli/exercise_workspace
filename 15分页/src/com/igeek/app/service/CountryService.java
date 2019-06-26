package com.igeek.app.service;

import java.sql.SQLException;
import java.util.List;

import com.igeek.app.dao.ICountryDAO;
import com.igeek.app.dao.impl.CountryDAOImpl;
import com.igeek.app.pojo.Country;
import com.igeek.app.pojo.PageBean;

public class CountryService 
{
	
	public PageBean<Country> findCoutryByPage(int page) 
	{
		// 每页数量
		int countPerPage = 10;
		
		ICountryDAO dao = new CountryDAOImpl();
		
		// 国家总数
		long count = 0;
		try {
			count = dao.getCountryCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 计算总页数
		int pageAllCount = (int) count / countPerPage;
		
		if(page<1) page=1;
		if(page>pageAllCount) page=pageAllCount;
		
		List<Country> list = null;
		try {
			list = dao.findCountry((page - 1) * countPerPage, countPerPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		// 计算范围
		int start = (page-1)/countPerPage*countPerPage+1;
		int end = start+9;	
		if(end>countPerPage) end=countPerPage;
		
		// 	
		PageBean<Country> bean = new PageBean(list,page,pageAllCount,countPerPage,start,end);
		
		return bean;
	}

}
