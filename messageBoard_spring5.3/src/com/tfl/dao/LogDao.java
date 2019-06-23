package com.tfl.dao;

import java.util.List;
import java.util.Map;

public interface LogDao {
	int insert(String context) throws Exception;
	List<Map<String,Object>> selectAll() throws Exception;
}
