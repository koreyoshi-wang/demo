package com.springdemo.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springdemo.entities.User;
import com.springdemo.impl.LoginServiceImpl;
import com.springdemo.service.LoginService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-servlet.xml"})
public class jdbcTest {
	@Resource
	private LoginServiceImpl loginServiceImpl;
	
	@Test
	public void test() {
		User user = loginServiceImpl.getUserByName("luhugu@163.com");	
		Assert.assertEquals("123456", user.getPassword());
	}

}
