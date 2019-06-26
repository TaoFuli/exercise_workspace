package com.igeek.school.servlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import com.igeek.school.dao.IStudentDAO;
import com.igeek.school.dao.impl.StudentDAOImpl;
import com.igeek.utils.JDBCUtils;

import junit.framework.TestCase;

import javax.servlet.annotation.WebServlet;

@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 接收参数
		String name = req.getParameter("name");
		System.out.println("学生的名字");
		
		// 2. 处理
		IStudentDAO dao = new StudentDAOImpl();
		int result = dao.addStudent(name);

		// 3.显示
		if(result>0)
		{
			pw.println("添加学生成功");
		}
		else
		{
			pw.println("添加学生失败");
		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
