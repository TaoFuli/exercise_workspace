package com.igeek.app.servlet;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

// maxFileSize 允许上传文件的最大值 ,-1表示没有限制

@WebServlet("/upload2")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024)
public class UploadServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();

		// 表单中的文本内容
//		String username = req.getParameter("username");
//		System.out.println(username);

		Collection<Part> parts = req.getParts();
		System.out.println(parts.size());

		for (Part part : parts) {

			if (part.getName().equals("file")) {

				// 得到文件名
				String fileName = part.getHeader("Content-Disposition");
				System.out.println(fileName);
				int start = fileName.indexOf("filename=") + "filename=".length() + 1;
				fileName = fileName.substring(start);
				fileName = fileName.substring(0, fileName.length() - 1);
				System.out.println("fileName:" + fileName);

				// 为了避免文件名重复,产生一个随机的文件名
				// UUID
				// 3. UUID
				// 通用唯一识别码 Uinversally Unique Identifer
				// 时间 网卡 cpu
				// 这个编码任何电脑、任何时间 都不会重复
				// 数据库如果使用它作为每条记录的唯一标识，就不会产生重复
				UUID uuid = UUID.randomUUID();
				String newFilename = uuid.toString() + fileName.substring(fileName.length() - 4);

				// 将文件保存到指定位置
				String filePath = getServletContext().getRealPath("/uploadImages/") + newFilename;
				System.out.println(filePath);
				part.write(filePath);

				pw.println("上传的" + fileName + "已保存");
				pw.println("<img witdh=\"100\" height=\"100\" src=\"uploadImages/" + newFilename + "\" />");

			}

		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
