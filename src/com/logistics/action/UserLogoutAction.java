package com.logistics.action;

import com.logistics.domain.User;

public class UserLogoutAction extends ModelAction<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		session.removeAttribute("loginUserName");
		session.removeAttribute("loginUserRole");
		return INPUT;
	}
}
