package com.logistics.service;

import java.util.List;

import com.logistics.domain.Dailybill;

public interface IDailybillService {
	public abstract boolean add(final Dailybill dailybill);
	public abstract List<Dailybill> findAll();
	public abstract Dailybill findById(final int id);
	public abstract List<Dailybill> search(String str1,String str2,String str3);
	public abstract boolean del(final int id);
	public abstract boolean edit(final int id);
	public abstract boolean update(final Dailybill dailybill);
	public abstract List<Dailybill> searchByDate(String str1,String str2);

}
