/**
 * 
 */
package com.springdemo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.springdemo.entities.User;
import com.springdemo.service.LoginService;

@Controller
@RequestMapping(value="/dashboard")
public class DashboardController extends BaseController{
	
	@Resource
	private LoginService loginService;
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping
	public ModelAndView dashboard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		ModelAndView modelAndView = createLayoutView("dashboard");
		List userList = loginService.getAllUsers();
		map.put("contextPath", request.getContextPath());
		//map.put("data", userList);
		modelAndView.addAllObjects(map);
		return modelAndView;
	}
	
	@RequestMapping(value = "/json")
	@ResponseBody
	public String getAllUser(HttpServletRequest request,
			HttpServletResponse response) {
		String sEcho = request.getParameter("draw");
		JSONObject json = new JSONObject();
        List<User> userList = loginService.getAllUsers();
        json.put("sEcho", Integer.parseInt(sEcho));
        json.put("data", userList);
        json.put("iTotalDisplayRecords", userList.size());
        json.put("iTotalRecords", userList.size());
		return json.toJSONString();
	}
	
	@RequestMapping(value = "/addUser")
	@ResponseBody
	public String addUser(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean userExist = loginService.queryUserExist(username);
		if (userExist){
			return "0";
		}else{
			int returnCode = loginService.addUser(username, password);
			return String.valueOf(returnCode);
		}
	}
	
	@RequestMapping(value = "/deleteUser")
	@ResponseBody
	public String deleteUser(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		if (username != null){
			int returnCode = loginService.deleteUser(username);
			return String.valueOf(returnCode);
		}
		return "0";
	}
}
