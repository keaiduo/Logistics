package com.logistics.service;

import java.util.List;
import com.logistics.domain.Otherbill;

public interface IOtherbillService {
	
	public abstract boolean add(final Otherbill otherbill);
	public abstract List<Otherbill> findAll();
	public abstract Otherbill findById(final int id);
	public abstract List<Otherbill> search(String str1,String str2,String str3);
	public abstract boolean del(final int id);
	public abstract boolean edit(final int id);
	public abstract boolean update(final Otherbill otherbill);
	public abstract List<Otherbill> searchByDate(String str1,String str2);

}
