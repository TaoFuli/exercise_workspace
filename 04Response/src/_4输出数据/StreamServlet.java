package _4输出数据;

import java.io.PrintWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/StreamServlet")
public class StreamServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//resp.setContentType("text/html;charset=utf-8"); // 注意:这行不要,因为返回的数据是图片不是text/html类型
		
		// 1. 获取响应对象的字节输出流,包装在一个缓冲流内
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		
		// 2. 
		int tmpId = 3491+(int)(Math.random()*4);
		String imgPath = getServletContext().getRealPath("/imgs/"+tmpId+".png");
		System.out.println(imgPath);
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imgPath));
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=bis.read(buf))!=-1) {
			bos.write(buf, 0, len);
		}
		
		bos.close();
		bis.close();
		
		
		
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
