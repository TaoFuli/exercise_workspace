package com.tfl.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *数据库访问工具 
 *
 */
public class C3P0Utils {
	
	private static ComboPooledDataSource dataSource = null;
	static {
		try {
			dataSource = new ComboPooledDataSource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回数据源
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	

}
