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
 * ģ�Ͳ����ݲ��ܹ���
 * ����ת����forward(����������)������Ҫ�κ���Ҫ
 * �����ض���redirect��
 * ʹ��SessionAttributes����Mapģ�͹�����ʽ���������ض���ֵ����ֵ����session�У�����Ҫ���
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
		//�����ض���s2�����ݶ�ʧ
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
