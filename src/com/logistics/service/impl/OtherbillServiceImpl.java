package com.logistics.service.impl;

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



	

}
