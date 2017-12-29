package cn.et.springmvc.lesson01.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.springmvc.lesson01.dao.FoodDao;

/**
 * �־ò�
 * @author Administrator
 *
 */
@Repository
public class FoodDaoImpl implements FoodDao {

	@Autowired
	JdbcTemplate jdbc;
	
	public Integer getFoodListCount(String name){

		//������ѯ�����ݵ�SQL���
		String sql = "select count(*) as cr from food where foodname like'%"+name+"%'";
		//��ȡ�����ݿ��ѯ��������
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		//���ز鵽����������
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
