package _5下载;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("Hello");
		//随机一张图片
		int tmpId=3491+(int)(Math.random()*4);
		//图片的名字
		String fileName="中文"+tmpId+".png";
		//得到文件在服务器上的绝对路径getRealPath()
		String filePath=getServletContext().getRealPath("/images/"+fileName);
		
		//----------------------------------------------------------
		//这块代码处理中文文件名
		//获得浏览器类型
		String agent=req.getHeader("User-Agent");
		//根据不同浏览器类型处理文件名不同
		if(agent.contains("MSIE"))
		{
			//IE浏览器
			fileName=URLEncoder.encode(fileName, "utf-8");
			fileName=fileName.replace("+", " ");
			
		}else if(agent.contains("Firefox"))
		{
			//火狐浏览器
			BASE64Encoder base64Encoder=new BASE64Encoder();
			fileName="=?utf-8?B?"+base64Encoder.encode(fileName.getBytes("utf-8"))+"?=";
		}
		else
		{
			//其它浏览器
			fileName=URLEncoder.encode(fileName, "utf-8");
		}
		
		
		//-----------------------------------------------------------
		//下面2行，告诉浏览器采用下载方式打开
		
		//Content-Type 文件的媒体格式
		resp.setContentType(this.getServletContext().getMimeType(filePath));
		//Content-Disposition 设置要下载的文件名
		resp.setHeader("Content-Disposition", "attachment;filename="+fileName);
		//将图片读取并输出到输出流
		BufferedOutputStream bos=new BufferedOutputStream(resp.getOutputStream());
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(fileName));
		byte[] buf=new byte[1024];
		int len=0;
		while((len=bis.read(buf))!=-1)
		{
			bos.write(buf,0,len);
		}
		bis.close();
		bos.close();
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
