package _4输出数据;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StreanServlet")
public class StreanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		//1.获取响应对象的字节输出流，包转载一个缓冲流中
		BufferedOutputStream bos=new BufferedOutputStream(resp.getOutputStream());
		
		//2.读取图片文件的数据
		int tmpId=3491+(int)(Math.random()*4);
		String filePath=getServletContext().getRealPath("/images/"+tmpId+".png");
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(filePath));
		byte[] buf=new byte[1024];
		int len=0;
		while((len=bis.read(buf))!=-1)
		{
			bos.write(buf,0,len);
		}
		bis.close();
		bos.close();
		
		pw.println("Hello");
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
