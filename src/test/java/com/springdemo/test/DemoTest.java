package com.springdemo.test;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springdemo.web.DemoController;

@ContextConfiguration(locations= {"classpath:spring-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoTest {
	@Autowired
	DemoController demoController;
	
	@Test
	public void sayHelloTest(){
		assert(demoController.sayHello(DemoController.NAME).equals("Wellcom DevOps !"));
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
