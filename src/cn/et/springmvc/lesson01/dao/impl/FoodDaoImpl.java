package cn.et.springmvc.lesson01.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.springmvc.lesson01.dao.FoodDao;

/**
 * 持久层
 * @author Administrator
 *
 */
@Repository
public class FoodDaoImpl implements FoodDao {

	@Autowired
	JdbcTemplate jdbc;
	
	public Integer getFoodListCount(String name){

		//创建查询总数据的SQL语句
		String sql = "select count(*) as cr from food where foodname like'%"+name+"%'";
		//获取从数据库查询到的数据
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		//返回查到的数据总数
		return Integer.parseInt(list.get(0).get("cr").toString());
	}
	
	public List<Map<String, Object>> getFoodListPage(String name,int startIndex,int pageCount){
		String sql = "select * from food where foodname like '%"+name+"%' limit "+startIndex+","+pageCount;
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		return list;
	}
	
	

	public Map<String, Object> queryById(String foodid) {
		String sql = "select * from food where foodid= "+foodid;
		Map<String, Object> map = jdbc.queryForList(sql).get(0);
		return map;
	}
	
	
	public void saveFood(String name, String price,String imgPath){
		
		String sql = "insert into food(foodname,price,img) values('"+name+"','"+price+"','"+imgPath+"')";
		jdbc.execute(sql);
	}
	
	
	
	
	public void deleteFood(String fid){
		String sql = "delete from food where foodid="+fid;
		jdbc.execute(sql);
	}
	
	
	public void updateFood(String foodid,String foodname,String price,String imgPath){
		String sql = "update food set foodname='"+foodname+"',price="+price+",img='"+imgPath+"' where foodid="+foodid;
		jdbc.execute(sql);
	}


	
}
