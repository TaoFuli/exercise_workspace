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
		
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 连接数据库
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "root";
		Connection con=null;
		PreparedStatement stmt = null;
		int result = 0;
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "insert into students values (null,?)";
			// 执行SQL
			stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
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
