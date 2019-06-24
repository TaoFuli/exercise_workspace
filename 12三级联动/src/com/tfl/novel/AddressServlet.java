package com.tfl.novel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/address")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CityDao cityDao=new CityDao();
	private final  Gson gs=new Gson();
	/**
	 * 当然，我们也可以用下面这种方式对集合进行转化，gs.toJSON();和下面的转化效果相同的
	 * 
	 * JSONSerializer jsonstr=new JSONSerializer();
	 * jsonstr.deepSerializer();深序列化转化为json字符串
	 */
	
//	private final JSONSerializer jsonSer=new JSONSerializer();
	//jsonSer.deepSerializer(list);深序列化也可以转化为json字符串
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String method = req.getParameter("method");
		if (null != method && !"".equals(method))
		{
			if ("initProvince".equals(method))
			{
				initProvince(req, resp);
			} else if ("getCity".equals(method))
			{
				getCity(req, resp);
			}else if("getArea".equals(method)) {
				getArea(req,resp);
			}
		}
	}
 
	/**
	 * 查询对应区县
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void getArea(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
 
		String cityCode = req.getParameter("cityCode");
		List<Area> areaList = cityDao.getAreaByCityCode(cityCode);
		String jsonStr = gs.toJson(areaList);
		out.print(jsonStr);
		
	}
 
	/**
	 * 查询对应城市
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void getCity(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
 
		String provCode = req.getParameter("provCode");
		List<City> cityList = cityDao.getCityByProvCode(provCode);
		//Gson.jar包转化json字符串
		String jsonStr = gs.toJson(cityList);
		out.print(jsonStr);
 
	}
 
	/**
	 * 初始化地址栏
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void initProvince(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
 
		List<Province> provList = cityDao.getAllProvince();
		
		String jsonStr = gs.toJson(provList);
		out.print(jsonStr);
		
	}

}
