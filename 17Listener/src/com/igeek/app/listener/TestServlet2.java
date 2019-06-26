package com.igeek.app.listener;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		

		HttpSession s = req.getSession();
		
//		Customer c = new Customer(10,"小明");
//		s.setAttribute("customer", c);
//		s.removeAttribute("customer");
		
		pw.println("sessionid:"+s.getId());
		
		Person p = new Person(1,"大名");
		s.setAttribute("person", p);
		
		pw.println("abc");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
