package com.logistics.service;

import java.util.List;

import com.logistics.vo.Profit;

public interface IProfitService {
	
	public abstract List<Profit> exportprofit(String str1,String str2,String str3);

}
