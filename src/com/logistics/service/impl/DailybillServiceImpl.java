package com.logistics.service.impl;

import java.util.List;

import com.logistics.dao.IDailybillDao;
import com.logistics.domain.Dailybill;
import com.logistics.service.IDailybillService;

public class DailybillServiceImpl implements IDailybillService {

	private IDailybillDao dailybillDao;
	
	
	public IDailybillDao getDailybillDao() {
		return dailybillDao;
	}


	public void setDailybillDao(IDailybillDao dailybillDao) {
		this.dailybillDao = dailybillDao;
	}


	@Override
	public boolean add(Dailybill dailybill) {
		// TODO Auto-generated method stub
		return this.dailybillDao.insert(dailybill) != null ? true :false;
	}


	@Override
	public List<Dailybill> findAll() {
		// TODO Auto-generated method stub
		return this.dailybillDao.selectAll();
	}


	@Override
	public Dailybill findById(int id) {
		// TODO Auto-generated method stub
		return this.dailybillDao.selectById(id);
	}


	@Override
	public List<Dailybill> search(String str1, String str2, String str3) {
		// TODO Auto-generated method stub
		String hql= "select * from dailybill ";
		boolean judge = false;
		if (str1 != null && !str1.trim().equals("")) {
			hql+=" where ddate ='"+str1+"'";			
			judge = true;
		}
		//
		if (str2 != null && !str2.trim().equals("")) {
			if (judge) {
				hql+=" and dorder ='"+str2+"'";
				judge = false;
			} else {
				hql+=" where dorder ='"+str2+"'";
				judge = true;
			}
		}
		//提货车号
		if (str3 != null && !str3.trim().equals("")) {
			if (judge) {
				hql+=" and dbroker ='"+str3+"'";
				judge = false;
			} else {
				hql+=" where dbroker ='"+str3+"'";
				judge = true;
			}
		}	
		List<Dailybill> lists = this.dailybillDao.select(hql);
		for(Dailybill list : lists){
			System.out.println(list.toString());
		}
		return this.dailybillDao.select(hql);
	}


	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return this.dailybillDao.delete(id) == 0 ? true : false;
	}


	@Override
	public boolean update(Dailybill dailybill) {
		// TODO Auto-generated method stub
		return this.dailybillDao.update(dailybill) == 0 ? true : false;
	}


	@Override
	public boolean edit(int id) {
		// TODO Auto-generated method stub
		return this.dailybillDao.selectById(id) != null ? true : false;
	}


	@Override
	public List<Dailybill> searchByDate(String str1, String str2) {
		// TODO Auto-generated method stub
		String hql= "select * from dailybill ";
		boolean judge = false;
		if(str1 != null && !str1.trim().equals("")){
			hql += "where ddate >='"+str1+"'";
			judge = true;
		}
		if(str2 != null && !str2.trim().equals("")){
			if(judge){
				hql += " and ddate <= '"+str2+"'";
				judge = false;
			}else{
				hql += " where ddate <= '"+str2+"'";
			}
		}
		List<Dailybill> lists = this.dailybillDao.select(hql);
		for(Dailybill list : lists){
			System.out.println(list.toString());
		}
		return this.dailybillDao.select(hql);
	}

}
