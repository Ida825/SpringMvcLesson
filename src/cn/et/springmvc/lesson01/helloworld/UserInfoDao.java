package cn.et.springmvc.lesson01.helloworld;


public interface UserInfoDao {
	/**
	 * �����û���Ϣ
	 * @param name ����
	 * @param sex �Ա�
	 * @param age ����
	 * @param desci ����
	 */
	public void addUserInfo(String name,String sex,int age,String desci);
	
	/**
	 * ���� id��ѯ�û���Ϣ
	 * @param id
	 * @param name
	 */
	public void selectUserInfo(String id);
	
	
	public void updateUserInfo();
	
	public void deleteUserInfo(String id);
	
}
