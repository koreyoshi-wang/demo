/**
 * 
 */
package com.springdemo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.impl.BaseServiceImpl;

@Controller()
public class BaseController {
	@Resource
	public BaseServiceImpl baseService;
	
	protected ModelAndView createSingleView(String path)
    {
        ModelAndView view = new ModelAndView();
        view.setViewName(path);
        return view;
    }
    
    protected ModelAndView createLayoutView(String path)
    {
        return createLayoutView(path, null);
    }
    
    protected ModelAndView createLayoutView(String path, String layout)
    {
        ModelAndView view = new ModelAndView("common/layout");
        if (layout == null){
            view.setViewName("common/layout");
        }else{
            view.setViewName(layout);
        }
        view.addObject("header_path", "header.jsp");
        view.addObject("siderbar_path", "sidebar.jsp");
        view.addObject("footer_path", "footer.jsp");
        view.addObject("content_path", "../"+ path + ".jsp");
        return view;
    }
	
}
