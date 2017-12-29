package cn.et.springmvc.lesson06.dao;

import java.util.List;
import java.util.Map;

public interface MyFoodDao {
	/**
	 * 查询菜品
	 * @param foodname 菜名
	 * @return 菜品列表
	 */
	public List<Map<String, Object>> queryFood(String foodname);
	
	/**
	 * 删除菜品
	 * @param foodid 菜品id
	 */
	public void deleteFood(String foodid);
	
	/**
	 * 修改菜品
	 * @param foodname 菜名
	 * @param price 价格
	 */
	public void updateFood(String foodid,String foodname,String price);
	
	/**
	 * 
	 * @param foodname 菜名
	 * @param price 价格
	 */
	public void addFood(String foodname,String price);
}
