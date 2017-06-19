package com.locknlol.coukie.domain.interceptor;

import com.locknlol.coukie.domain.member.configuration.SessionLogin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler;
			SessionLogin sessionLogin = hm.getMethodAnnotation(SessionLogin.class);
			if (sessionLogin != null) {
				if (request.getSession().getAttribute("admin") == null) {
					response.sendRedirect("/login/form");
					return false;
				}
			}
		}
		return true;
	}
}
