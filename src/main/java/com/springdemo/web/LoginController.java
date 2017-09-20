package com.springdemo.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.entities.User;
import com.springdemo.service.LoginService;

@Controller
public class LoginController {	
	@Resource
	private LoginService loginService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		ModelAndView modelAndView = new ModelAndView("login");
		map.put("contextPath", request.getContextPath());
		modelAndView.addAllObjects(map);
		return modelAndView;
	}
	
	@RequestMapping(value = "login/validate")
	@ResponseBody
	public boolean validate(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = loginService.getUserByName(username);
		boolean loginResult = false;
		if (user != null) {
			String pwddb = user.getPassword();
			if (pwddb.equals(password)) {
				loginResult = true;
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("username", username);
			}
		}
		return loginResult;
	}
}