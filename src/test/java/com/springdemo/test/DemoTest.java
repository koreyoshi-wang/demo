package com.springdemo.test;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoTest {
	
	@Test
	public void successTest(){
		assertTrue(true);
	}
	
	
	@Test
	public void failureTest(){
		assertTrue(true);
	}

}
