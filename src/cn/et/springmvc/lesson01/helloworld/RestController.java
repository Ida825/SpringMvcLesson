package cn.et.springmvc.lesson01.helloworld;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * ������ύ��ʽ������@RequestMappingָ������Դ����һ��
 * �����׳�405�쳣������ʽ��֧��
 * @author Administrator
 *
 */

@Controller
public class RestController {
	/*
	*//**
	 * user/2
	 * user/3
	 * ��ѯ
	 * @param userId
	 * @return
	 *//*
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String index(@PathVariable(value="id") String userId){
		
		return "/lesson01/user.jsp";
	}
	
	
	*//**
	 * ����
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
	 * �޸�
	 * @return
	 * @throws IOException
	 *//*
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable(value="id") String userid,String name,HttpServletResponse response) throws IOException{//
		response.getWriter().println(userid+"---"+name+" --> update success!!");
		return null;
	}
	
	*//**
	 * ɾ��
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
