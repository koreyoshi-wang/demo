package com.springdemo.selenium;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class Selenium {

	@Test
	public void test() {
		//For windows
		//String driverPath = "C:/selenium";
		//System.setProperty("webdriver.gecko.driver", driverPath+"/geckodriver.exe");
		//For Linux
		System.setProperty("webdriver.gecko.driver", "/bin/selenium/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");
		Assert.assertTrue(driver.getTitle().contains("百度"));
		driver.quit();
	}

}
