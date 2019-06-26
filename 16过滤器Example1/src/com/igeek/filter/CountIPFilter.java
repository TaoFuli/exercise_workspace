package com.igeek.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CountIPFilter
 */
@WebFilter("/*")
public class CountIPFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CountIPFilter() {
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

		
		// 得到用户的ip
		String ip = request.getRemoteAddr();
		// 从ServletContext中取出map
		ServletContext context = request.getServletContext();
		Map<String,Integer> map = (Map<String,Integer>)context.getAttribute("map");
		// 从map取出当前ip的count值
		int count = 0;
		if(map.containsKey(ip))
		{
			count = map.get(ip);
		}
		// 计数+1
		count++;
		// 重新放入map
		map.put(ip, count);
		// 重新放入ServletContext
		context.setAttribute("map", map);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		// 创建建一个空的map放在ServletContext
		Map<String, Integer> map = new HashMap<>();
		ServletContext context = fConfig.getServletContext();
		context.setAttribute("map", map);
		
		
	}

}
