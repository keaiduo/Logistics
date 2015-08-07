package com.logistics.dao.base;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable, ID extends Serializable>{
	//����һ��ͨ�õ�ʵ�����ݿ���ӵĲ���
	public abstract T insert(final T entity);
	//����һ��ͨ�õ�ʵ�ֲ�ѯ�Ĳ���
	public abstract List<T> selectAll();
	//����һ��ͨ�õİ���ID������ѯ����
	public abstract T selectById(final ID id);
	//����һ��ͨ�õ�ʵ�����ݿ���µĲ���
	public abstract int update(final T entity);
	//����һ��ͨ�õ�ʵ�����ݿ�ɾ���Ĳ���
	public abstract int delete(final ID id);
	//����һ��ͨ�õ�������ѯ����
	public abstract List<T> select(final String condision); 
	
	

}
