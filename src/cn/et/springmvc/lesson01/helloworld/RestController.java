package cn.et.springmvc.lesson01.helloworld;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 浏览器提交方式必须与@RequestMapping指定的资源动作一致
 * 否则抛出405异常：请求方式不支持
 * @author Administrator
 *
 */

@Controller
public class RestController {
	/*
	*//**
	 * user/2
	 * user/3
	 * 查询
	 * @param userId
	 * @return
	 *//*
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String index(@PathVariable(value="id") String userId){
		
		return "/lesson01/user.jsp";
	}
	
	
	*//**
	 * 新增
	 * @param name
	 * @param response
	 * @return
	 * @throws IOException
	 *//*
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addUser(String name,HttpServletResponse response) throws IOException{//
		response.getWriter().println(name+" --> add success!!");
		return null;
	}
	
	*//**
	 * 修改
	 * @return
	 * @throws IOException
	 *//*
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable(value="id") String userid,String name,HttpServletResponse response) throws IOException{//
		response.getWriter().println(userid+"---"+name+" --> update success!!");
		return null;
	}
	
	*//**
	 * 删除
	 * @param userid
	 * @param response
	 * @return
	 * @throws IOException
	 *//*
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable(value="id") String userid,HttpServletResponse response) throws IOException{//
		response.getWriter().println(userid+" --> delete success!!");
		return null;
	}*/
}
