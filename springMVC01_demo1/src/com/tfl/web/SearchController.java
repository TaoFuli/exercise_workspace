package com.tfl.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tfl.service.ItemService;

@Controller
public class SearchController {
	@Autowired
	private ItemService service;
	
	/**
	 * 模型和视图
	 * @return
	 */
	@RequestMapping("/show.action")
	public ModelAndView doSome() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/index.jsp");//设置视图的名称
		
		//默认存放在请求中
		Map<String,Object> model=mv.getModel();
		model.put("ItemList", service.findAll());
		
		return mv;
	}
}
