package com.logistics.service.impl;

import java.util.List;

import com.logistics.dao.IOtherbillDao;
import com.logistics.domain.Otherbill;
import com.logistics.service.IOtherbillService;

public class OtherbillServiceImpl implements IOtherbillService {
	
	private IOtherbillDao otherbillDao;

	public IOtherbillDao getOtherbillDao() {
		return otherbillDao;
	}

	public void setOtherbillDao(IOtherbillDao otherbillDao) {
		this.otherbillDao = otherbillDao;
	}

	@Override
	public boolean add(Otherbill otherbill) {
		// TODO Auto-generated method stub
		return this.otherbillDao.insert(otherbill) != null ? true : false;
	}

	@Override
	public List<Otherbill> findAll() {
		// TODO Auto-generated method stub
		return this.otherbillDao.selectAll();
	}

	@Override
	public Otherbill findById(int id) {
		// TODO Auto-generated method stub
		return this.otherbillDao.selectById(id);
	}

	@Override
	public List<Otherbill> search(String str1, String str2, String str3) {
		// TODO Auto-generated method stub
		String hql= "select * from otherbill ";
		boolean judge = false;
		if (str1 != null && !str1.trim().equals("")) {
			hql+=" where odate ='"+str1+"'";			
			judge = true;
		}
		//
		if (str2 != null && !str2.trim().equals("")) {
			if (judge) {
				hql+=" and obiz ='"+str2+"'";
				judge = false;
			} else {
				hql+=" where obiz ='"+str2+"'";
				judge = true;
			}
		}
		//提货车号
		if (str3 != null && !str3.trim().equals("")) {
			if (judge) {
				hql+=" and obroker ='"+str3+"'";
				judge = false;
			} else {
				hql+=" where obroker ='"+str3+"'";
				judge = true;
			}
		}	
		List<Otherbill> lists = this.otherbillDao.select(hql);
		for(Otherbill list : lists){
			System.out.println(list.toString());
		}
		return this.otherbillDao.select(hql);
	}

	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return this.otherbillDao.delete(id) == 0 ? true : false;
	}

	@Override
	public boolean edit(int id) {
		// TODO Auto-generated method stub
		return this.otherbillDao.selectById(id) != null ? true : false;
	}

	@Override
	public boolean update(Otherbill otherbill) {
		// TODO Auto-generated method stub
		return this.otherbillDao.update(otherbill) == 0 ? true : false;
	}



	

}
