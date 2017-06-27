package com.springdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	public static String NAME = "DevOps";
	//public static String NAME = "DXC";
	
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView modelAndView = new ModelAndView("index");
    	modelAndView.addObject("wellcomMsg", sayHello(NAME));
        return modelAndView;
    }
    
    public String sayHello(String name){
    	return "Wellcom " + name + " !";
    }
}
