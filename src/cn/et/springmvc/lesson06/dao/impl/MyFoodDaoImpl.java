package cn.et.springmvc.lesson06.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.springmvc.lesson06.dao.MyFoodDao;

@Repository
public class MyFoodDaoImpl implements MyFoodDao{

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Map<String, Object>> queryFood(String foodname) {
		String sql = "select * from food where foodname like '%"+foodname+"%'";
		 
		return jdbc.queryForList(sql);
	}

	public void addFood(String foodname, String price) {
		String sql="insert into food(foodname,price) values('"+foodname+"','"+price+"')";
		System.out.println(sql);
		jdbc.execute(sql);	
	}

	public void deleteFood(String foodid) {
		jdbc.execute("delete from food where foodid="+foodid);
	}

	public void updateFood(String foodid,String foodname, String price) {
		jdbc.execute("update food set foodname='"+foodname+"', price='"+price+"' where foodid="+foodid);
	}
	
}
