package cn.et.springmvc.lesson06.dao;

import java.util.List;
import java.util.Map;

public interface MyFoodDao {
	/**
	 * ��ѯ��Ʒ
	 * @param foodname ����
	 * @return ��Ʒ�б�
	 */
	public List<Map<String, Object>> queryFood(String foodname);
	
	/**
	 * ɾ����Ʒ
	 * @param foodid ��Ʒid
	 */
	public void deleteFood(String foodid);
	
	/**
	 * �޸Ĳ�Ʒ
	 * @param foodname ����
	 * @param price �۸�
	 */
	public void updateFood(String foodid,String foodname,String price);
	
	/**
	 * 
	 * @param foodname ����
	 * @param price �۸�
	 */
	public void addFood(String foodname,String price);
}
