package com.lzm.interceptor;


import com.lzm.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interceptor1 implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String requestURI = request.getRequestURI();
		//���ʵ��һ���ַ����Ƿ���������е���һԪ��
		if(!requestURI.contains("login") ){
			User user = (User) session.getAttribute("user");
			if (null == user) {
//	/û�е�½��ת���½����
				request.getRequestDispatcher("/To_login.action").forward(request,response);
				return false;
			}
		}
		return true;
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("������ 1");
		
	}
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ҳ����Ⱦ�� 1");
		
	}



}
