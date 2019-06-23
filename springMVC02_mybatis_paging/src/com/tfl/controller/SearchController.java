package com.tfl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tfl.pojo.Paging;
import com.tfl.pojo.User;
import com.tfl.service.UserService;

@Controller
public class SearchController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/search.do")
	public ModelAndView doSearch(String queryString,String ttt,Integer p,HttpSession session) {
		int pageSize=3;
		int currPage=1;
		ModelAndView mv=new ModelAndView("index");
		
		if("yes".equals(ttt)) {
			session.setAttribute("queryString", queryString);
		}else {
			if(p!=null&&p>0)currPage=p;
			queryString=(String)session.getAttribute("queryString");
		}
		
		if(queryString!=null) {
			Paging<User> paging=service.search(queryString, currPage, pageSize);
			mv.addObject("paging",paging);
		}
		return mv;
	}
	
}
