package cn.et.springmvc.lesson01.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface FoodDao {
	/**
	 * ��ȡ������
	 * @param name
	 * @return
	 */
	public Integer getFoodListCount(String name);

	/**
	 * ��ѯ��(��ҳ)
	 * @param name
	 * @return
	 */
	public List<Map<String, Object>> getFoodListPage(String name,int startIndex,int pageCount);

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