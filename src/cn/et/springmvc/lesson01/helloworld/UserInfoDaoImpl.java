package cn.et.springmvc.lesson01.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class UserInfoDaoImpl {
	@Autowired
	private JdbcTemplate jdbc;
	
	public void addUserInfo(String name, String sex, int age, String desci) {	
		String sql = "insert into userinfo(name,sex,age,desci) values('"+name+"','"+sex+"','"+age+"','"+desci+"')";
		jdbc.execute(sql);
	}

	public void deleteUserInfo() {
		String sql = "delete userinfo where id=3";
		jdbc.execute(sql);
		
	}

	public void selectUserInfo() {
		String sql = "select * from userinfo where id=1";
		jdbc.execute(sql);		
	}

	public void updateUserInfo(String name, String sex, int age, String desci) {
		String sql = "update userinfo set name='"+name+"', sex='"+sex+"',age='"+age+"',desci='"+desci+"' where id=2";
		jdbc.execute(sql);
		
	}

}
