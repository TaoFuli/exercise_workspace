package com.igeek.school.servlet;

import java.io.PrintWriter;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.school.dao.IStudentDAO;
import com.igeek.school.dao.impl.StudentDAOImpl;
import com.igeek.school.domain.Student;

import javax.servlet.annotation.WebServlet;

@WebServlet("/list")
public class ListStudentServet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 
		
		
		// 2. 
		IStudentDAO dao = new StudentDAOImpl();
		List<Student> list = dao.findAll();
		
		// 3.  显示
		pw.println("<table border=\"1\">");
		for(Student stu:list)
		{
			pw.println("<tr>");
			pw.println("<td>"+stu.getId()+"</td><td>"+stu.getName()+"</td>");
			pw.println("</tr>");
		}
		pw.println("<table>");
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
