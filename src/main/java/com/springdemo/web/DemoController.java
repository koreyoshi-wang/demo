package com.springdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	//If TEST_NAME equals NAME test will success!
	public static String NAME = "DevOps";
	//public static String TEST_NAME = "DevOps";
	public static String TEST_NAME = "Test";
	
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView modelAndView = new ModelAndView("index");
    	modelAndView.addObject("welcomeMsg", sayHello(TEST_NAME));
        return modelAndView;
    }
    
    public String sayHello(String name){
    	return "Welcome " + name + " !";
    }
}
