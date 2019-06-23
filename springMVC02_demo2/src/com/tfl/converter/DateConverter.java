package com.tfl.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	/**
	 * 转换数据格式
	 */
	@Override
	public Date convert(String strDate) {
		String pattern="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
