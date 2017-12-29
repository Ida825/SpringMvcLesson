package cn.et.springmvc.lesson01.helloworld;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * springmvc中一个路径和方法的映射叫一个action（动作）
 * @author Administrator
 *
 */
@Controller
public class HelloController {
	
	@RequestMapping("/test")
	public String index(HttpServletResponse response) throws IOException{
		response.getWriter().print("hello springmvc");
		return null;
	}
	
	/*@RequestMapping("/test1")
	public String index1(HttpServletResponse response) throws IOException{
		response.getWriter().print("hello test1");
		return null;
	}*/
	
	
	/*//获取参数
	@RequestMapping("/test")
	public String param(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.getWriter().println(request.getParameter("name")+"--------"+"hello springmvc");
		return null;
	}
	
	@RequestMapping("/param")
	public String index(String id,String name,HttpServletResponse response) throws IOException{
		response.getWriter().println(id+"--"+name);
		return null;
	}
	
	@RequestMapping("/user")
	public String index(User u,HttpServletResponse response) throws IOException{
		response.getWriter().println(u.getId()+"=="+u.getName());
		return null;
	}*/
	
	//跳转到index.jsp
	@RequestMapping("/mvc")
	public String index(HttpServletRequest request){
		request.setAttribute("name", "ww");
		return "/index.jsp";//返回路径
	}
}
