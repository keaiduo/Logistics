package com.logistics.service;

import java.util.List;

import com.logistics.vo.Profit1;

public interface IProfitService {
	
	public abstract List<Profit1> exportprofit(String str1,String str2,String str3);

}
