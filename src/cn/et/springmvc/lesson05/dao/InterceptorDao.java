package cn.et.springmvc.lesson05.dao;


public interface InterceptorDao {
	/**
	 * �޸����
	 * @param money
	 */
	public void updateMoney(Integer money);
	
	/**
	 * ��ѯ���
	 * @return
	 */
	public Integer selectMoney();
}
