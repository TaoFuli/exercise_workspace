package com.shop.utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 准备：导包  C3p0两个包，mysql的实现包，dbutils包
 * 	配置文件放在src目录下
 *  C3p0Utils工具类：专门提供C3p0链接池的数据源
 */
public class C3p0Utils {
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource("tfl");
	private C3p0Utils(){}
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
}
