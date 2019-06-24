package com.tfl.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tfl.pojo.Paging;
import com.tfl.pojo.SharedFile;
import com.tfl.services.SharedFileServiceImpl;

import flexjson.JSONSerializer;

@WebServlet("/sharedFile.do")
public class SharedFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final SharedFileServiceImpl ss=new SharedFileServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		int currPage=1;
		int pageSize=5;
		try {
		currPage=Integer.parseInt(req.getParameter("page"));
		pageSize=Integer.parseInt(req.getParameter("rows"));
		}catch(Exception e) {}
		
		Paging<SharedFile> pp=ss.search(pageSize,currPage);
		List<SharedFile> data = pp.getData();
		List<SharedFile> newData=new ArrayList<>();
		Iterator<SharedFile> it = data.iterator();
		//file:///E://apache-tomcat-8.5.34//wtpwebapps//NetworkDisk//../		NetworkDisk
		//ServletContext().getRealPath
		while(it.hasNext()) {
			 SharedFile tmp = it.next();
			 tmp.setFilePath("<a href='"
					 +tmp.getFilePath()+tmp.getRandomFileName()+tmp.getFileType()
					 +"'>"+tmp.getFilePath()+tmp.getFileName()+tmp.getFileType()+"</a>");
			 newData.add(tmp);
		}
		
		Map<String,Object> map=new HashMap<>();
		map.put("total", pp.getRowsCount());
		map.put("rows", newData);
		
		JSONSerializer s=new JSONSerializer().include("rows");
		pw.print(s.serialize(map));
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
