package com.tfl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tfl.pojo.Item;
import com.tfl.service.ItemService;

@Controller
public class GetJSONController {
	@Autowired
	private ItemService service;
	
	@RequestMapping("/get1")
	public @ResponseBody Item get1() {
		return service.getOne();
	}
	@RequestMapping("/get2")
	public @ResponseBody List<Item> get2(){
		return service.getAll();
	}
	
	@RequestMapping("set1")
	public void setJSON(@RequestBody Item item,HttpServletResponse response) throws IOException {
		System.out.println("item="+item);
		response.getWriter().println("<h1>OK</h1>");
	}
	
	
}
