package com.igeek.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class TestDemo {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException 
	{
	
		
		// Map -> Bean对象
//		Map<String,Object> info = new HashMap<>();
//		info.put("id", 1001);
//		info.put("name", "张三");
//		info.put("age", 18);
//		info.put("sex", "male");
//		System.out.println(info);
//		
//		Student stu = new Student();
//
////		BeanUtils.copyProperties(stu, info);
//		BeanUtils.populate(stu, info);
//		System.out.println(stu);
//		
//		// Bean对象 -> Map
//		Map<String,Object> info2 = BeanUtils.describe(stu);
//		System.out.println(info2);
		
		
		
		
		// 如果有日期 需要注册一个转换器
		DateConverter dc = new DateConverter();
		dc.setPatterns(new String[]{"yyyy-MM-dd","yyyy/MM/dd"});
		ConvertUtils.register(dc,Date.class);
		
		Map<String,Object> info3 = new HashMap<>();
		info3.put("id", 1001);
		info3.put("name", "张三");
		info3.put("age", 18);
		info3.put("sex", "male");
		info3.put("birthday", "2001-01-05");
		Student stu3 = new Student();
		BeanUtils.copyProperties(stu3, info3);
		System.out.println(stu3);
	}

}
