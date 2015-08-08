package com.logistics.service.impl;

import java.util.List;

import com.logistics.dao.ITransportDao;
import com.logistics.domain.Transport;
import com.logistics.service.ITransportService;

public class TransportServiceImpl implements ITransportService {
	
	private ITransportDao transportDao;
	
	

	public ITransportDao getTransportDao() {
		return transportDao;
	}



	public void setTransportDao(ITransportDao transportDao) {
		this.transportDao = transportDao;
	}



	@Override
	public boolean add(Transport transport) {
		// TODO Auto-generated method stub
		return this.transportDao.insert(transport) != null ? true : false;
	}



	@Override
	public List<Transport> findAll() {
		// TODO Auto-generated method stub
		return this.transportDao.selectAll();
	}



	@Override
	public Transport findById(int id) {
		// TODO Auto-generated method stub
		return this.transportDao.selectById(id);
	}



	@Override
	public List<Transport> search(String str1, String str2, String str3) {
		// TODO Auto-generated method stub
		String hql= "select * from transport ";
		boolean judge = false;
		if (str1 != null && !str1.trim().equals("")) {
			hql+=" where tno ='"+str1+"'";			
			judge = true;
		}
		//
		if (str2 != null && !str2.trim().equals("")) {
			if (judge) {
				hql+=" and tgsdh ='"+str2+"'";
				judge = false;
			} else {
				hql+=" where tgsdh ='"+str2+"'";
				judge = true;
			}
		}
		//提货车号
		if (str3 != null && !str3.trim().equals("")) {
			if (judge) {
				hql+=" and tthch ='"+str3+"'";
				judge = false;
			} else {
				hql+=" where tthch ='"+str3+"'";
				judge = true;
			}
		}	
		List<Transport> lists = this.transportDao.select(hql);
		for(Transport list : lists){
			System.out.println(list.toString());
		}
		return this.transportDao.select(hql);
	}



	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return this.transportDao.delete(id) == 0 ? true :false;
	}



	@Override
	public boolean edit(int id) {
		// TODO Auto-generated method stub
		Transport transport = this.transportDao.selectById(id);
		return transport != null ? true : false;
	}



	@Override
	public boolean update(Transport transport) {
		// TODO Auto-generated method stub
		return this.transportDao.update(transport) == 0 ? true : false;
	}

}
