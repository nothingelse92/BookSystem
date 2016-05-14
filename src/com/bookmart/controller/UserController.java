package com.news.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.controller.model.UserLogModel;
import com.news.po.User;
import com.news.po.UserLog;
import com.news.service.UserLogServiceI;
import com.news.service.UserServiceI;
import com.news.util.EncryptUtil;
import com.news.util.JSONUtil;

/**
 * 用户控制器
 * 
 * @author 
 * 
 */
@Controller
public class UserController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserServiceI userService;
	@Autowired
	private UserLogServiceI userLogService;

	@RequestMapping(value = "/check.html")
	public String check() {
		System.out.println("--------");
		return "check";
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	
	
	@RequestMapping(value = "/user_login")
	public ModelAndView user_login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView mav = new ModelAndView("./login.html");  
        return mav;  
		
	}
	
	
	@RequestMapping(value = "/login.do")
	public void login(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession) throws IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		User u = userService.login(new User(username, pwd));
		if (u != null) {
			httpSession.setAttribute("name", u.getName());
			httpSession.setAttribute("id", u.getId());
			u.setPassword("");
			JSONUtil.outString(response, JSONUtil.toJSONString(u));
		}
	}
	

	@RequestMapping(value = "/register.do")
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String email=request.getParameter("email");
		int phone=Integer.parseInt(request.getParameter("contact"));
		User u = new User(username, pwd);
		u.setEmail(email);
		u.setPhone(phone);
		
		userService.register(u);
	}
	
	
	

	public void logData(UserLog log, User u, HttpServletRequest request) {
		log.setLoginDate(new Date());
		log.setLoginIp(request.getRemoteAddr());
		log.setUser(u);
		userLogService.save(log);
		request.getSession().setAttribute("LOG", log);
		request.getSession().setAttribute("LOGIN_USER", u);
	}

	/**
	 * 登出
	 */
	@RequestMapping(value = "/layout.html")
	public String layout(HttpServletRequest request) {
		UserLog log = (UserLog) request.getSession().getAttribute("LOG");
		log.setQuitDate(new Date());
		userLogService.update(log);
		request.getSession().removeAttribute("LOGIN_USER");
		// 首页还没读数据跳到具体文件
		return "redirect:index.jsp";
	}

	/**
	 * 查看登录日志
	 */
	

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/registerPage.html")
	public ModelAndView registerPage() {
		return new ModelAndView("register").addObject(new User());
	}

	/**
	 * 注册
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/register.html")
	public String register(HttpServletRequest request, @ModelAttribute("user") @Valid User user,
			BindingResult result) throws Exception {
		System.out.println(result.hasErrors());
		if (!result.hasErrors()) {
			user.setPassword(EncryptUtil.addMD5(user.getPassword()));
			userService.save(user);
			logData(new UserLog(), user, request);
			return "index.html";
		}
		return "register";
	}
}
