package com.logistics.service;

import java.util.List;

import com.logistics.domain.Transport;

public interface ITransportService {
	
	public abstract boolean add(final Transport transport);
	public abstract List<Transport> findAll();
	public abstract Transport findById(final int id);
	public abstract List<Transport> search(String str1,String str2,String str3);
	public abstract boolean del(final int id);
	public abstract boolean edit(final int id);
	public abstract boolean update(final Transport transport);
	
	

}
