package cn.et.springmvc.lesson05.dao;


public interface InterceptorDao {
	/**
	 * ĞŞ¸ÄÓà¶î
	 * @param money
	 */
	public void updateMoney(Integer money);
	
	/**
	 * ²éÑ¯Óà¶î
	 * @return
	 */
	public Integer selectMoney();
}
