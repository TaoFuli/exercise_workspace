package com.igeek.app.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.security.util.Password;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
@WebFilter("/*")
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("自动登录过滤器 进行过滤");
		
		// 没有登录的状态, 且有Cookie 就实现自动登录
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		String password = null;
		
		if(username==null)
		{
			Cookie[] cookies = req.getCookies();
			if(cookies!=null)
			{
				for(int i=0;i<cookies.length;i++)
				{
					Cookie c = cookies[i];
					if(c.getName().equals("username"))
					{
						username =c.getValue();
					}
					else if(c.getName().equals("password"))
					{
						password = c.getValue();
					}
				}
				
				if(username!=null&&password!=null)
				{
					
					
					if("admin".equals(username)&&"123".equals(password))
					{
						session.setAttribute("username", username);
						
						// 设置Cookie
						Cookie c1 = new Cookie("username",username);
						Cookie c2 = new Cookie("password",password);
						c1.setMaxAge(3*60);
						c2.setMaxAge(3*60);
						c1.setPath("/");
						c2.setPath("/");
						resp.addCookie(c1);
						resp.addCookie(c2);
						
						// 如果用户之前访问了某个页面
						resp.sendRedirect(req.getRequestURI());
					}
					else
					{
						resp.sendRedirect("login.jsp");
					}
					return;
				}
			}	
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
