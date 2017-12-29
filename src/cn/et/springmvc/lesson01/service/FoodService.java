package cn.et.springmvc.lesson01.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.et.springmvc.lesson01.utils.PageTools;

public interface FoodService {
	
	/**
	 * 查询菜(分页)
	 * @param name
	 * @return
	 */
	public PageTools getFoodListPage(String name,int curPage);

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
