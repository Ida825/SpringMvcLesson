package cn.et.springmvc.lesson01.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface FoodDao {
	/**
	 * 获取总条数
	 * @param name
	 * @return
	 */
	public Integer getFoodListCount(String name);

	/**
	 * 查询菜(分页)
	 * @param name
	 * @return
	 */
	public List<Map<String, Object>> getFoodListPage(String name,int startIndex,int pageCount);

	/**
	 * 根据菜品编号查询
	 * @param foodid
	 * @return
	 */
	public Map<String,Object> queryById(String foodid);
	
	/**
	 * 根据菜名添加菜品
	 * @param name
	 * @param price 
	 * @throws SQLException 
	 */
	public abstract void saveFood(String name, String price, String imgPath);

	/**
	 * 删除菜品
	 * @param did
	 * @throws SQLException
	 */
	public abstract void deleteFood(String fid);

	/**
	 * 修改菜品
	 * @param did
	 * @throws SQLException
	 */
	public abstract void updateFood(String foodid, String foodname,
			String price, String imgPath);
	
	
}