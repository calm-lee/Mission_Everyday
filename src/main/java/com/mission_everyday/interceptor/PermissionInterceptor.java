package com.mission_everyday.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PermissionInterceptor  implements HandlerInterceptor {

	//private Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// ���� Ȯ�� => ������ �α��� ����
		HttpSession session = request.getSession();
		String userLoginId = (String) session.getAttribute("userLoginId");

		// URI - url path Ȯ��
		String uri = request.getRequestURI();
		
		logger.info("#### preHandle():" + uri);
		
		// ��α��� && /post => �α���(sign_in) �������� redirect
		if (userLoginId == null && uri.startsWith("/post")) {
			response.sendRedirect("/user/sign_in");
			return false; // ������� boolean�̱� ������ ��ȯ���� false�� ���� (�׷��� ���� controller�� �Ѿ�� ����)
		}

		// �α��� && /user => post list �������� redirect
		if (userLoginId != null && uri.startsWith("/user")) {
			response.sendRedirect("/mission/main");
			return false;
		}
		return true;
	}

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		String uri = request.getRequestURI();
		logger.info("#### postHandle():" + uri);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
		String uri = request.getRequestURI();
		logger.info("#### afterCompletion():" + uri);
		
	}
}