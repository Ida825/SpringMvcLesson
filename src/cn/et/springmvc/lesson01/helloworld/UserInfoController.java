package cn.et.springmvc.lesson01.helloworld;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*@Controller
public class UserInfoController {
	@Autowired
	private UserInfoDao dao;
	
	*//**
	 * 新增
	 * @throws IOException 
	 *//*
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addUser(UserInfo user,HttpServletResponse response) throws IOException{
		dao.addUserInfo(user.getName(), user.getSex(), user.getAge(), user.getDesci());
		response.getWriter().println("add success!");
		return null;
	}
	
	*//**
	 * 查询
	 * @param userid
	 * @param response
	 * @return
	 * @throws IOException
	 *//*
	@RequestMapping(value="/user/1",method=RequestMethod.GET)
	public String selectUser(HttpServletResponse response) throws IOException{
		dao.selectUserInfo("");
		response.getWriter().println("<table><tr><th>id</th><th>name</th><th>sex</th><th>age</th><th>desci</th></tr>" +
				"<tr><td>id</td><td>name</td><td>sex</td><td>age</td><td>desci</td></tr>" +
				"</table>");
		
		return null;
	}
	
	*//**
	 * 修改
	 * @param userid
	 * @param response
	 * @return
	 * @throws IOException
	 *//*
	@RequestMapping(value="/user/2",method=RequestMethod.PUT)
	public String updateUser(UserInfo user,HttpServletResponse response) throws IOException{
		dao.updateUserInfo();
		response.getWriter().println("update success!");
		return null;
	}
	
	*//**
	 * 删除
	 * @param userid
	 * @param response
	 * @return
	 * @throws IOException
	 *//*
	@RequestMapping(value="/user/3",method=RequestMethod.DELETE)
	public String deleteUser(HttpServletResponse response) throws IOException{
		dao.deleteUserInfo(null);
		response.getWriter().println("delete success!");
		return null;
	}
}*/
