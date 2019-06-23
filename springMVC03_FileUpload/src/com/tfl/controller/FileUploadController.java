package com.tfl.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@PostMapping("upload")
	public String doupload(MultipartFile myfile,Model model,HttpServletRequest request
			,HttpServletResponse response) throws IllegalStateException, IOException, ServletException {
		String exts="jpeg,jpg,png,gif,txt,java";//可以上传的文件类型
		
		//随机产生一个文件名
		String fileName=UUID.randomUUID().toString();
		//获取文件名
		String oriName=myfile.getOriginalFilename();
		//文件后缀名
		String extName=oriName.substring(oriName.lastIndexOf("."));
		if(!exts.contains(extName.substring(1).toLowerCase())) {
			throw new RuntimeException("只能上传图片");
		}
		
		fileName+=extName;
		System.out.println("fileName="+fileName);
		
		//存储
		myfile.transferTo(new File("C:/images/"+fileName));
		//添加到model
		model.addAttribute("picName",fileName);
//		request.getRequestDispatcher("upload.jsp").forward(request,response);
		return "upload";
	}
}
