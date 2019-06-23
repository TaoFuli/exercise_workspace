package com.tfl.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestRequestParamsController {
	
	/**
	 * 测试 自动识别HttpServletRequest 并进行赋值
	 * @param request
	 */
	@RequestMapping("/test1.do")
	public void testMethod(HttpServletRequest request) {
		String name=request.getParameter("name");
		System.out.println("请求的name值为："+name);
	}
	@RequestMapping("/test2.do")
	public void testMethod2(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>我的Response测试网页</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>测试Response的网页</h2>");
		out.println("<a href='test3.do'>下一个网页</a>");
		out.println("</body>");
		out.println("</html>");
	}
	@RequestMapping("/test3.do")
	public void testMethod3(HttpServletResponse response,HttpServletRequest request) throws IOException {
		String name=request.getParameter("name");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>我的测试Request和Response的网页</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>请求返回的值name："+name+"</h2>");
		out.println("<a href='test4.do'>下一个网页</a>");
		out.println("</body>");
		out.println("<head>");
	}
	@RequestMapping("/test4.do")
	public void testMethod4(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int width=500;
		int height=100;
		BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g=img.getGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(25, 25, width, height);
		g.setColor(Color.RED);
		g.drawString("浩浩学习，天天向上", 50, 50);
		PrintWriter out=response.getWriter();
		out.println("<a href='test5.do'>");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		out.println("</a>");
	}
	@RequestMapping("/test5.do")
	public ModelAndView testMethod5(HttpSession session,Model m,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		//向会话中存放值
		session.setAttribute("suibian", "session会话");
		session.setAttribute("session", "session会话2");
		//使用Model村值
		m.addAttribute("modelAttrName", "Model中存放的值");
		m.addAttribute("modelAttrAge",18);
		//modelMap中存放值
		modelMap.put("modelMapValue", "ModelMap中的值");
		//request中存储值
		request.setAttribute("ResquestValueName", "Resquest请求中存放值");
		
		try {
			request.getRequestDispatcher("/show.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("/show.jsp");
	}
}


