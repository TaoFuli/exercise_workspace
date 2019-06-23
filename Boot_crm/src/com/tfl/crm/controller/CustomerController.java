package com.tfl.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tfl.crm.pojo.BaseDict;
import com.tfl.crm.service.BaseDictService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;
	
	
	@Autowired
	private BaseDictService baseDictService;
	@RequestMapping("list")
	public String queryCustomerList(Model model) {
		//客户来源
		List<BaseDict> fromType=this.baseDictService.queryBaseDictByDictTypeCode("002");
		//所属行业
		List<BaseDict> industryType=this.baseDictService.queryBaseDictByDictTypeCode("001");
		//客户级别
		List<BaseDict> levelType=this.baseDictService.queryBaseDictByDictTypeCode("006");
		
		//把前端页面需要显示的数据放到模型中
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		return "customer";
	}
}
