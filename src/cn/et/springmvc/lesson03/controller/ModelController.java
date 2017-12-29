package cn.et.springmvc.lesson03.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {
	
	@RequestMapping(value="/case",method=RequestMethod.GET)
	public String case1(Map map)throws Exception{
		//用map传入值
		map.put("sex", "male");
		return "/lesson03/res.jsp";
	}
	
	
	@RequestMapping(value="/case2",method=RequestMethod.GET)
	public ModelAndView case2(Map map)throws Exception{
		//用map传入值
		ModelAndView m = new ModelAndView("/lesson03/res.jsp");
		//ModelAndView m = new ModelAndView();
		//m.setViewName("/lesson03/res.jsp");
		m.addObject("sex", "female");
		return m;
	}
}
