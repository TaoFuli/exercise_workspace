package _5下载;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

import javax.servlet.annotation.WebServlet;

@WebServlet("/download")
public class DownServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		// 1. 获取响应对象的字节输出流,包装在一个缓冲流内
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());

		// 2.
		int tmpId = 3491 + (int) (Math.random() * 4);
		String imgPath = getServletContext().getRealPath("/imgs/" + tmpId + ".png");
		System.out.println(imgPath);
		
		
		
		// 设置响应头告诉客户端 使用下载方式

		String fileName = tmpId + ".png";
//		3）通知浏览器以下载的方式请求资源
		// a.Content-Type 设置文件媒体格式
		resp.setContentType(this.getServletContext().getMimeType(fileName));
		// 处理中文文件名乱码
		String header = req.getHeader("User-Agent");// 客户端的浏览器类型
		if (header.contains("Firefox")) {
			// 表示当前是火狐
			BASE64Encoder base64Encoder = new BASE64Encoder();
			fileName = "=?utf-8?B?" + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";

		} else {
			// 谷歌
			fileName = URLEncoder.encode(fileName, "utf-8");

		}
		// b.Content-Disposition 设置要被下载的文件名
		resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);

		

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imgPath));

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = bis.read(buf)) != -1) {
			bos.write(buf, 0, len);
		}

		bos.close();
		bis.close();

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
