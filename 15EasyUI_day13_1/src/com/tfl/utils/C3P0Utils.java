package com.tfl.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	private static ComboPooledDataSource dataSource = null;
	
	static{
		try {
			dataSource = new ComboPooledDataSource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回数据源
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
}
