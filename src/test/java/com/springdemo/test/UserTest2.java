package com.springdemo.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.dao.UserDao;
import com.springdemo.impl.UserServiceImpl;

public class UserTest2 {
    
    //初始化容器
    ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    //获得bean
    UserDao userDao = ctx.getBean("userDao",UserDao.class);
    
    @Test
    public void testUserName() {
    	//访问数据库
        String username = userDao.getUserById(1).getUsername();
        Assert.assertEquals(username, "admin");
    }   
}