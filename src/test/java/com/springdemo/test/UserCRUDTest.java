package com.springdemo.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springdemo.entities.User;
import com.springdemo.impl.LoginServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-servlet.xml"})
public class UserCRUDTest {
	
	@Resource
	private LoginServiceImpl loginServiceImpl;
	String userName = "testCase";
	String password = "123456";
	
	@Test
	public void test01() {
		int returnCode = loginServiceImpl.addUser(userName, password);
		Assert.assertEquals(1, returnCode);
	}
	
	@Test
	public void test02() {
		boolean userExist = loginServiceImpl.queryUserExist(userName);
		Assert.assertEquals(true, userExist);
	}
	
	@Test
	public void test03() {
		User user = loginServiceImpl.getUserByName(userName);
		Assert.assertEquals(userName, user.getUsername());
		Assert.assertEquals(password, user.getPassword());
	}
	
	@Test
	public void test04() {
		int returnCode = loginServiceImpl.deleteUser(userName);
		Assert.assertEquals(1, returnCode);
	}
	
}
