package com.tfl.exceptionresolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("发生异常分析的处理器："+handler);
		System.out.println("异常对象："+ex);
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("err", "对不起，发生了一个错误！你是一个好人，但是我们不合适");
		return mv;
	}
	
}
