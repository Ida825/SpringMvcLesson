package cn.et.springmvc.lesson05.controller;

import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson05.service.impl.InterceptorServiceImpl;

@Controller
public class MyInterController {
	@RequestMapping(value="/interceptor")
	public String mid(OutputStream os) throws Exception{
		os.write("hello".getBytes());
		return null;
	}
	
	/**
	 * ×ªÇ®µÄaction
	 */
	@Autowired
	InterceptorServiceImpl is;
	
	@RequestMapping(value="/tm",method=RequestMethod.POST)
	public String transMoney(Integer money,OutputStream os) throws Exception{
		is.updateMoney(money);
		os.write(("lostedmoney is: "+is.selectMoney()).getBytes());
		return null;
	}
}
