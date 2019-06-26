package com.igeek.app.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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

		System.out.println("登录过滤器 进行过滤");
		
		// 当前访问的是不是登录相关页面
		// 其他页面
		// 		判断用户当前是否登录,如果没有登录 则跳转登录页面
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		// 用户请求的URI
		String request_url = req.getRequestURI();
		System.out.println(request_url);// /16过滤器Example2/login.jsp
		//
		String app_url = req.getContextPath();
		System.out.println(app_url);// /16过滤器Example2
		
		// 从URI中去掉应用的app的字符串
		String page_url = request_url.substring(app_url.length());
		System.out.println(page_url);// /login.jsp
		
		if(page_url.equals("/login.jsp")||
				page_url.equals("/loginchk")||
				page_url.equals("/logout.jsp"))
		{
			chain.doFilter(request, response);
		}
		else
		{
			HttpSession session = req.getSession();
			String username = (String)session.getAttribute("username");
			if(username==null)
			{
				// 记录当前用户想要访问的页面,以便用户登录后,跳转回来
				
				// 参数
				String queryStr = req.getQueryString();
				if(queryStr!=null)
				{
					request_url= request_url+"?"+queryStr;
				}
				session.setAttribute("origin_url", request_url);				
				resp.sendRedirect("login.jsp");
			}
			else
			{
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
// 当用户访问a.jsp 因为没有登录被跳转到 login.jsp 
// 登录成功后,让用户继续跳转到a.jsp
// 