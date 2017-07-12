package com.springdemo.test;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springdemo.web.DemoController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-servlet.xml"})
public class DemoTest {
	@Autowired
	DemoController demoController;
	
	@Test
	public void sayHelloTest(){
		assertTrue("'TEST_NAME' must equals 'NAME' !", demoController.sayHello(DemoController.TEST_NAME).equals("Welcome "+ DemoController.NAME +" !"));
	}
	
	@Test
	public void successTest(){
		assertTrue(true);
	}
	
	@Test
	public void failureTest(){
		assertTrue(true);
	}

}
