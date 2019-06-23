package com.tfl.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetAndPostController {
	
	@RequestMapping("t1")
	public ModelAndView test1() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("show1");//逻辑视图名
		//存储一个值
//		Map<String,Object> map=mv.getModel();
		ModelMap mm=mv.getModelMap();
		mm.put("haha", "modelMap");
//		mm.addAttribute(attributeName, attributeValue);
		mv.addObject("hehe", "这是存放在modelAndView中的一个值");
		return mv;
	}
	/**
	 * 返回字符串
	 */
	@RequestMapping("t2")
	public String test2(HttpServletRequest request) {
		request.setAttribute("t2", "这是t2中request的值");
		return "show2";
	}
	
	@RequestMapping("t3")
	public String test3(Model model) {
		model.addAttribute("t3", "这是test3中的model中存放的attribute值");
		return "show3";
	}
	
	@RequestMapping("t4")
	public String test4(ModelMap mm) {
		mm.put("t4", "这是t4中的modelMap中存放的值");
		return "show4";
	}
	/**
	 * 无返回值，void
	 * 默认是在映射请求后加后缀访问
	 */
	@RequestMapping("t5")
	public void test5() {
		
	}
	
	/**
	 * 无返回值，服务器的转发
	 */
	@RequestMapping("t6")
	public void test6(HttpServletRequest request,HttpServletResponse response) throws Exception, IOException {
		request.setAttribute("t6", "这是t6中在request中存放的，无返回值使用默认逻辑视图名。经过getRequestDispatcher服务器转发则实际访问的为转发页面，逻辑视图名默认");
		request.getRequestDispatcher("/WEB-INF/views/show6.jsp").forward(request, response);
	}
	/**
	 * 客户端的行为，重定向 sendRedirect()
	 * @throws IOException 
	 */
	@RequestMapping("t7")
	public void test7(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setAttribute("t7", "t7在request中存放，客户端的重定向sendRedirect(),默认逻辑视图名");
		response.setCharacterEncoding("gzip");
		response.setContentType("text/html;charset=utf-8");
		response.sendRedirect("https://www.baidu.com/s??ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=小翠");
	}
	/**
	 * 无返回值servlet返回一个字符串 可以作为ajax的返回值
	 * @throws IOException 
	 */
	@RequestMapping("t8")
	public void test8(String name,HttpServletResponse response) throws IOException {
//		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		if("123".equals(name)){
			out.println("{rs:yes是}");
		}else {
			out.println("{rs:no不对}");
		}
	}
	
}
