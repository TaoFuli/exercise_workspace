package _6验证码;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkImage")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public static final char[] chars = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
    										'A', 'B', 'C', 'D', 'E','F', 'G', 'H', 'I', 'J',
    										'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
    										'U', 'V', 'W', 'X', 'Y', 'Z' };

    private static Random random = new Random();

    // 随机字符串
    public static String getRandomString(){

        StringBuffer sb = new StringBuffer();
        for(int i = 0;i <4;i++){
            sb.append(chars[random.nextInt(chars.length)]);
        }
        return sb.toString();
    }

    // 得到一个随机的颜色
    public static Color getRandomColor(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
   }

    // 得到一个随机的颜色 
    public static Color getReverColor(Color c){
        return new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue());        
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 创建随机的验证码的文字
        String randomString = getRandomString();

        // 得到随机的背景颜色
        Color c =getRandomColor();

        // 得到验证码的颜色
        Color reverse =getReverColor(c);

        // 创建一张图片 
        BufferedImage  bi =new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        // 得到绘图上下文  
        Graphics g = bi.getGraphics();
        // 设置字体  
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        // 使用颜色填充
        g.setColor(c);
        g.fillRect(0, 0, 100, 30);
        // 设置验证码颜色
        g.setColor(reverse);
        // 把验证码文字绘制到图片上 
        g.drawString(randomString, 18, 20);

        // 绘制100个小点 干扰
        for(int i=0 ,n=random.nextInt(100);i<n;i++){
            g.drawRect(random.nextInt(100), random.nextInt(30), 1, 1);
        }

      // 输出图片到 响应流中
        ImageIO.write(bi,"jpg",response.getOutputStream());        
    }  


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
