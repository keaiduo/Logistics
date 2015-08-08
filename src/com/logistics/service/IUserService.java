package com.logistics.service;

import java.util.List;

import com.logistics.domain.User;

public interface IUserService {
	
	/**
	 * �����û�
	 * @param user �����ӵ��û���Ϣ
	 * @return true���ӳɹ�������ʧ��
	 */
	public abstract boolean add(final User user);

	/**
	 * ��ѯ�����û���Ϣ
	 * @return �����û���Ϣ
	 */
	public List<User> selectAllUser();
	
	
	/**
	 * �û���½ 
	 * @return  0��½ʧ��,���������û�����
	 */
	public int userLogin(User loginUser);
}
