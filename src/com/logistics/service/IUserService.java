package com.logistics.service;

import java.util.List;

import com.logistics.domain.User;

public interface IUserService {
	
	/**
	 * 增加用户
	 * @param user 新增加的用户信息
	 * @return true增加成功，否则失败
	 */
	public abstract boolean add(final User user);

	/**
	 * 查询所有用户信息
	 * @return 所有用户信息
	 */
	public List<User> selectAllUser();
}
