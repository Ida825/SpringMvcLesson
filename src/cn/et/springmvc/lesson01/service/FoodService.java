package cn.et.springmvc.lesson01.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.et.springmvc.lesson01.utils.PageTools;

public interface FoodService {
	
	/**
	 * ��ѯ��(��ҳ)
	 * @param name
	 * @return
	 */
	public PageTools getFoodListPage(String name,int curPage);

	/**
	 * ���ݲ�Ʒ��Ų�ѯ
	 * @param foodid
	 * @return
	 */
	public Map<String,Object> queryById(String foodid);
	
	/**
	 * ���ݲ�����Ӳ�Ʒ
	 * @param name
	 * @param price 
	 * @throws SQLException 
	 */
	public abstract void saveFood(String name, String price, String imgPath);

	/**
	 * ɾ����Ʒ
	 * @param did
	 * @throws SQLException
	 */
	public abstract void deleteFood(String fid);

	/**
	 * �޸Ĳ�Ʒ
	 * @param did
	 * @throws SQLException
	 */
	public abstract void updateFood(String foodid, String foodname,
			String price, String imgPath);

}
