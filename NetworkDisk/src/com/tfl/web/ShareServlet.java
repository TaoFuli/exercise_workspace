package com.tfl.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/share1.do")
public class ShareServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		System.out.println(req.getParameter("sid"));
		pw.print("["
		+"{\"id\":101,\"filename\":\"/e:/path\"},"
		+ "{\"id\":102,\"filename\":\"/e:/adf}"
				+"]");
	}
}

