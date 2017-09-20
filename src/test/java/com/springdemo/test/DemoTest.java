package com.springdemo.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springdemo.impl.LoginServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-servlet.xml"})
public class DemoTest {
	
	@Resource
	private LoginServiceImpl loginServiceImpl;
	String userName = "test@hpe.com";
	
	@Test
	public void verifyUser() {
		boolean userExist = loginServiceImpl.queryUserExist(userName);
		Assert.assertEquals(true, userExist);
	}
}
