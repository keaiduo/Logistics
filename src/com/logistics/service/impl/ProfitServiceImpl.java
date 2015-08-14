package com.logistics.service.impl;

import java.util.List;

import com.logistics.dao.IProfitDao;
import com.logistics.domain.Bizlist;
import com.logistics.service.IProfitService;
import com.logistics.vo.Profit;

public class ProfitServiceImpl implements IProfitService {
	private IProfitDao profitDao;


	public IProfitDao getProfitDao() {
		return profitDao;
	}


	public void setProfitDao(IProfitDao profitDao) {
		this.profitDao = profitDao;
	}



	@Override
	public List<Profit> exportprofit(String str1, String str2, String str3) {
		// TODO Auto-generated method stub
		String hql = "select * from bizlist left join transport on bizlist.orderno=transport.tgsdh";
		boolean judge = false;
		if (str1 != null && !str1.trim().equals("")) {
			hql += " where bizlist.companyname = '" + str1 + "'";
			judge = true;
		}
		boolean judge2 = false;
		if (str2 != null && !str2.trim().equals("")) {
			if (judge) {
				hql += " and bizlist.startdate >= '" + str2 + "'";
				judge = false;
				judge2 = true;
			} else {
				hql += " where bizlist.startdate >= '" + str2 + "'";
				judge = true;
				judge2 = true;
			}
		}
		if (str3 != null && !str3.trim().equals("")) {
			if (judge || judge2) {
				hql += " and bizlist.startdate <= '" + str3 + "'";
				judge = false;
			} else {
				hql += " where bizlist.startdate <= '" + str3 + "'";
				judge = true;
			}
		}

		List<Profit> lists = this.profitDao.select(hql);
		for (Profit list : lists) {
			System.out.println(list.toString());
		}
		return this.profitDao.select(hql);
	}
	
	

}
