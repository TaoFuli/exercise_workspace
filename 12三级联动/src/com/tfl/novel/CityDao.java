package com.tfl.novel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tfl.utils.C3P0Utils;

public class CityDao {
	private final QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());

	/**
	 * 获取省份
	 * 
	 * @param id
	 * @return
	 * @throws SQLException 
	 */

	public List<Province> getAllProvince() {
		List<Province> list=new ArrayList<>();
		String sql="select * from province;";
		try {
			list=qr.query(sql, new BeanListHandler<Province>(Province.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<City> getCityByProvCode(String provCode) {
		// TODO Auto-generated method stub
		List<City> list=new ArrayList<>();
		String sql="select * from city where provincecode=?;";
		try {
			list=qr.query(sql, new BeanListHandler<City>(City.class),provCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Area> getAreaByCityCode(String cityCode) {
		// TODO Auto-generated method stub
		List<Area> list=new ArrayList<>();
		String sql="SELECT * FROM AREA WHERE citycode=?;";
		try {
			list=qr.query(sql, new BeanListHandler<Area>(Area.class),cityCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
