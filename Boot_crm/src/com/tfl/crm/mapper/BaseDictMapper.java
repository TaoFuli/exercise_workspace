package com.tfl.crm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfl.crm.pojo.BaseDict;

@Repository
public interface BaseDictMapper {
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
	
}
