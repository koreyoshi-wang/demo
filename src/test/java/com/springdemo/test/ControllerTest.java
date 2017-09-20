package com.springdemo.test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springdemo.entities.User;
import com.springdemo.service.LoginService;
import com.springdemo.web.DashboardController;
import com.springdemo.web.LoginController;

import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-servlet.xml"})
public class ControllerTest {
	
	private static MockHttpServletRequest request;    
	private static MockHttpServletResponse response;
    
	@Autowired
	private LoginController loginController;
	
	@Autowired
	private DashboardController dashboardController; 
	
	@Resource
	private LoginService loginService;
	
	User user = new User();
	static String userName = "testCase";
	static String password = "123456";
	
	@BeforeClass
	public static void setUp() {      
        request = new MockHttpServletRequest();        
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }
	
	
	/**
	 * Add user
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test01() {
		request.setParameter("username", userName);
		request.setParameter("password", password);
		String returnCode = dashboardController.addUser(request, response);
		Assert.assertEquals("1", returnCode);
	}
	
	/**
	 * Add same user again, failed.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test02() {
		request.setParameter("username", userName);
		request.setParameter("password", password);
		String returnCode = dashboardController.addUser(request, response);
		Assert.assertEquals("0", returnCode);
	}
	
	/**
	 * Add same user without password, failed.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test03() {
		request.setParameter("username", userName);
		//request.setParameter("password", "");
		String returnCode = dashboardController.addUser(request, response);
		Assert.assertEquals("0", returnCode);
	}
	
	/**
	 * User Login Test case.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test05() {
		request.setAttribute("username", userName);
		request.setAttribute("password", password);
		boolean returnCode = false;
		try {
			returnCode = loginController.validate(request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(true, returnCode);
	}
	
	/**
	 * Delete test user.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test06() {
		request.setAttribute("username", userName);
		String returnCode = dashboardController.deleteUser(request, response);
		Assert.assertEquals("1", returnCode);
	}
	
	/**
	 * Login controller modelAndView test case.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test07() {
		ModelAndView modelAndView = loginController.login(request, response);
		Assert.assertEquals("login", modelAndView.getViewName());
	}
	
	/**
	 * DashBoard modelAndView test case
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test08() {
		ModelAndView modelAndView = dashboardController.dashboard(request, response);
		System.out.println(modelAndView.getModel());
		boolean hasPage = modelAndView.getModel().containsValue("../dashboard.jsp");
		Assert.assertEquals("common/layout", modelAndView.getViewName());
		Assert.assertEquals(true, hasPage);
	}
}
