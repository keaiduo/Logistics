package com.logistics.action;

import com.logistics.domain.User;
import com.logistics.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class UserLoginAction extends ModelAction<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private IUserService userService;
	
	public String execute() throws Exception {
		System.out.println(user.toString());
		int loginResult=userService.userLogin(user);
		if(loginResult==0)
		{
			return INPUT;
		}else{
			request.getSession().setMaxInactiveInterval(3600);
			request.getSession().setAttribute("loginUserName", user.getUname());
			request.getSession().setAttribute("loginUserRole", loginResult);
			return SUCCESS;
		}
	}
	
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return getUser();
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
}
