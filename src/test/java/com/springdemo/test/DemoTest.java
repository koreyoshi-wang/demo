package com.springdemo.test;

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
	String userName = "aaa@hpe.com";
	
	@Test
	public void verifyUser() {
		boolean userExist = loginServiceImpl.queryUserExist(userName);
		Assert.assertEquals(true, userExist);
	}
	
	@Test
	public void test02() {
		Assert.assertEquals(true, 1 == 2);
	}
	
	@Test
	public void test03() {
		Assert.assertEquals(true, 3 == 4);
	}
	
	@Test
	public void test04() {
		Assert.assertEquals(true, 1 == 2);
	}
	
	@Test
	public void test05() {
		Assert.assertEquals(true, 3 == 4);
	}
	
	@Test
	public void test06() {
		Assert.assertEquals(true, 1 == 2);
	}
	
	@Test
	public void test07() {
		Assert.assertEquals(true, 3 == 4);
	}
}
