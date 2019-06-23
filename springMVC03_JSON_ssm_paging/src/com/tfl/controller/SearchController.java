package com.tfl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tfl.pojo.Paging;
import com.tfl.pojo.User;
import com.tfl.service.UserService;

@Controller
public class SearchController {
	@Autowired
	private UserService service;
	
	@RequestMapping("search.do")
	public ModelAndView doSearch(String queryString,
			String ttt,Integer p,HttpSession session) {
		int pageSize=3;
		int currPage=1;
		ModelAndView mv=new ModelAndView("index");
		if("yes".equals(ttt)) {//判断是表单提交还是分页请求
			session.setAttribute("queryString", queryString);
		}else {
			if(p!=null&&p>0) 
			{
				currPage=p;
			}
			queryString=(String)session.getAttribute("queryString");
		}
		
		if(queryString!=null) {
			Paging<User> paging=service.search(queryString, currPage, pageSize);
			if(currPage<=paging.getPageCount())
			{
				mv.addObject("paging", paging);
			}
		}
		return mv;
	}
	
	/**
	 * 返回JSON
	 */
	@RequestMapping("/search1.do")
	public @ResponseBody Paging<User> doSearch(
			@RequestParam(defaultValue="") String queryString,
			@RequestParam(defaultValue="1") Integer p,
			String ttt,
			HttpSession session){
		int pageSize=3;
		int currPage=1;
		if("yes".equals(ttt)) {
			session.setAttribute("queryString", queryString);
		}else {
			if(p!=null&&p>0) {
				currPage=p;
				queryString=(String)session.getAttribute("queryString");
			}
			else {
				System.out.println("查询的页面不存在");
			}
		}
		
		Paging<User> paging = service.search(queryString, currPage, pageSize);
		return paging;
	}
}
