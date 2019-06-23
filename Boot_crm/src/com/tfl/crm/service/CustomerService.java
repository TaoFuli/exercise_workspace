package com.tfl.crm.service;

import com.tfl.crm.pojo.Customer;
import com.tfl.crm.pojo.QueryVo;
import com.tfl.crm.utils.Page;

public interface CustomerService {
	/**
	 * 根据条件分页查询客户
	 * @param queryVo
	 * @return
	 */
	Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);
}
