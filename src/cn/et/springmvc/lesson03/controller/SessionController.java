package cn.et.springmvc.lesson03.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cn.et.springmvc.lesson01.helloworld.User;

/**
 * 模型层数据不能共享
 * 请求转发：forward(将参数共享)：不需要任何需要
 * 请求重定向：redirect：
 * 使用SessionAttributes（将Map模型共享）方式用于请求重定向传值，将值放入session中，用完要清除
 * 
 * @author Administrator
 *
 */
@SessionAttributes("user")
@Controller
public class SessionController {
	
	/*@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(Map map){
		map.put("age", 15);
		//请求重定向到s2后，数据丢失
		return "redirect:/s2";
	}
	
	
	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(String id,HttpServletResponse response) throws IOException{
		response.getWriter().println(id);
		return null;
	}*/
	
	
	@ModelAttribute("user")
	public User getUser(){
		User user = new User();
		return user;
	}
	
	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(@ModelAttribute("user") User user){
		
		return "redirect:/s2";
	}
	
	
	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(Map map,HttpServletResponse response,SessionStatus sessionStatus) throws IOException{
		User user = (User)map.get("user");
		response.getWriter().println(user.getId());
		sessionStatus.setComplete();
		return null;
	}
}
