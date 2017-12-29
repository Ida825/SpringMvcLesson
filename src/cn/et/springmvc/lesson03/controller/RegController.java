package cn.et.springmvc.lesson03.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson03.entity.UserInfo;

@Controller
public class RegController {
	/**
	 * @Valid ���Զ�У��ע��
	 * @param user
	 * @return
	 */
	
	
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String reg(@ModelAttribute("user") @Valid UserInfo user,BindingResult error){
		if(!user.getPassword().equals(user.getRepassword())){
			error.addError(new FieldError("user","password","�������벻һ��"));
		}
		
		if(error.hasErrors()){
			return "/lesson03/reg.jsp";
		}
		return "/lesson03/suc.jsp";
	}
}
