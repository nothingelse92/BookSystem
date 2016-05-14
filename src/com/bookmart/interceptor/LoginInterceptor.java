package com.news.interceptor;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.news.po.User;

/**
 * 登录拦截器
 * @author 杨超民  2013-7-17  下午3:28:51
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) throws Exception {
		logger.debug("after-----------");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
			ModelAndView view) throws Exception {
		logger.debug("post-------------");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj)
			throws Exception {
		logger.debug("pre--------------");
		HttpSession session =  request.getSession();
		User u = (User) session.getAttribute("LOGIN_USER");
		if(u != null)
			return true;
		return false;
	}
}
