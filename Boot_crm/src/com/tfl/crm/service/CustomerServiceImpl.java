package com.tfl.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfl.crm.mapper.CustomerMapper;
import com.tfl.crm.pojo.Customer;
import com.tfl.crm.pojo.QueryVo;
import com.tfl.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		//设置查询条件，从那一条数据开始查询
		queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
		
		//查询数据结果集
		List<Customer> list=this.customerMapper.queryCustomerByQueryVo(queryVo);
		//查询到的数据总条数
		int total=this.customerMapper.queryCountByQueryVo(queryVo);
		
		//封装返回的page对象
		Page<Customer> page=new Page<>(total,queryVo.getPage(),queryVo.getRows(),list);
		
		return page;
	}

}
