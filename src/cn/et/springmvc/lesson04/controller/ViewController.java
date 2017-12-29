package cn.et.springmvc.lesson04.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson04.entity.UserInfo;

@Controller
public class ViewController {
	/**
	 * @Valid 会自动校验注解
	 * @param user
	 * @return
	 */
	
	
	@RequestMapping(value="/viewResolver",method=RequestMethod.GET)
	public String reg(@ModelAttribute("user") @Valid UserInfo user,BindingResult error){
		
		return "lesson04/result";
	}
	
	//装配MessageSource
	@Autowired
	MessageSource ms;
	@RequestMapping(value="/nation",method=RequestMethod.GET)
	public String nation(HttpServletResponse response,OutputStream os,Locale locale) throws NoSuchMessageException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		os.write(ms.getMessage("userName", null, locale).getBytes("UTF-8"));
		return null;
	}
	
	
	//建一个中转的controller
	@RequestMapping(value="/mid",method=RequestMethod.GET)
	public String mid() throws Exception{	
		return "/lesson04/reg.jsp";
	}
	
	
	@RequestMapping(value="/myreg")
	public String mid(@ModelAttribute("user") @Valid UserInfo user,BindingResult result) throws Exception{
		if(result.hasErrors()){
			return "/lesson04/reg.jsp";
		}
		return null;
	}
}
