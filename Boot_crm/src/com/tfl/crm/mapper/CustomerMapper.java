package com.tfl.crm.mapper;

import java.util.List;

import com.tfl.crm.pojo.Customer;
import com.tfl.crm.pojo.QueryVo;

public interface CustomerMapper {
	/**
	 * 分页查询数据
	 * @param queryVo
	 * @return
	 */
	List<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	/**
	 * 查询数据总条数
	 * @param queryVo
	 * @return
	 */
	int queryCountByQueryVo(QueryVo queryVo);
}
