package cn.et.springmvc.lesson01.helloworld;


public interface UserInfoDao {
	/**
	 * 新增用户信息
	 * @param name 姓名
	 * @param sex 性别
	 * @param age 年龄
	 * @param desci 描述
	 */
	public void addUserInfo(String name,String sex,int age,String desci);
	
	/**
	 * 根据 id查询用户信息
	 * @param id
	 * @param name
	 */
	public void selectUserInfo(String id);
	
	
	public void updateUserInfo();
	
	public void deleteUserInfo(String id);
	
}
