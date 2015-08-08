package com.logistics.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import com.logistics.dao.IUserDao;
import com.logistics.dao.base.HibernateGenericDaoImpl;
import com.logistics.domain.User;

public class UserDaoImpl extends HibernateGenericDaoImpl<User, Integer> implements
		IUserDao {

	@Override
	public int userLogin(User loginUser) {
		// TODO Auto-generated method stub
	
		Session session=null ;
		try{
			String queryStatement="from User u where u.uname=? and u.upassword=? ";
			session= this.sessionFactory.openSession();
			Query myQuery=session.createQuery(queryStatement);
			myQuery.setParameter(0, loginUser.getUname());
			myQuery.setParameter(1, loginUser.getUpassword());
			if(myQuery.list().size()==1)
			{
				return ((User)myQuery.list().get(0)).getRid();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			if(!(session==null))
				session.close();
		}
		return 0;
	}


}
