package com.tfl.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tfl.pojo.QuerVo;
import com.tfl.service.ItemService;

@Controller
public class SearchContoller {

	@Autowired
	private ItemService service;
	
	@RequestMapping("/show.action")
	public ModelAndView doSome() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/index.jsp");//设置视图的名称
		mv.addObject("ItemList",service.findAll());
		return mv;
	}
	
	@RequestMapping("/delete.action")
	public void del(Integer[] ids) {
		System.out.println("删除的ID有："+Arrays.toString(ids));
	}
	@RequestMapping("/delete2.action")
	public void del2(QuerVo query) {
		System.out.println("删除的query.ids有："+Arrays.toString(query.getIds()));
	}
	
	@RequestMapping("/delete3.action")
	public void del3(QuerVo qq) {
		System.out.println("删除的ID有："+qq.getMyids().size());
	}
	
}
