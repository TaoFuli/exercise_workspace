package com.tfl.crm.service;

import java.util.List;

import com.tfl.crm.pojo.BaseDict;

public interface BaseDictService {
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
	
}
