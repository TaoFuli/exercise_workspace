package com.igeek.qshop.servlet;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.igeek.qshop.dao.IGoodsDAO;
import com.igeek.qshop.dao.impl.GoodsDAOImpl;
import com.igeek.qshop.pojo.Goods;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminAddGoods")
public class AdminAddGoodsServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		
		// 1. 获取参数
		Goods goods = new Goods();
		try {
			BeanUtils.copyProperties(goods, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 2. 调用业务数据
		IGoodsDAO dao = new GoodsDAOImpl();
		boolean result = false;
		String msg = "";
		try {
			
			result = dao.add(goods);
			msg=result?"商品添加成功":"商品添加失败";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "商品添加失败";
		}
		
		// 3. 请求转发 或跳转
		HttpSession session = req.getSession();
		session.setAttribute("msg", msg);
		resp.sendRedirect("adminGoods");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
