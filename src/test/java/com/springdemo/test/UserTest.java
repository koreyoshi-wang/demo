package com.springdemo.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.springdemo.dao.UserDao;
import com.springdemo.entities.User;
import com.springdemo.impl.*;
import com.springdemo.service.LoginService;
public class UserTest {

    //static UserDao userDao;
	static LoginService loginService;

    @BeforeClass
	public static void beforeClass()
	{
    	loginService = new LoginServiceImpl();
	}
    
    @Test
    public void testGetAllBookTypes() {
    	User user = loginService.getUserByName("test");
    	System.out.println(user.getPassword());
        Assert.assertEquals(user.getPassword(), "test");
    }

}