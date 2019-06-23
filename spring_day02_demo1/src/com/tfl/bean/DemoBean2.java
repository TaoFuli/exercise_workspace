package com.tfl.bean;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class DemoBean2 {
	private Map<String ,String> map;
	private Properties properties;
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public void printMap() {
		for(Map.Entry<String, String > en:map.entrySet()) {
			System.out.println(en.getKey()+"="+en.getValue());
		}
	}
	public void printProperties() {
		for(Entry<Object, Object> en:properties.entrySet())
		{
			System.out.println(en.getKey()+"="+en.getValue());
		}
	}
 }
