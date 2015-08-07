package com.logistics.vo;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;



import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class CommonUtil {

	/**
	 * ���ݴ�����б����б��ڵ�����ת��Ϊjson���ݷ��ص�ǰ̨
	 * @param list
	 * @param total
	 * @throws Exception
	 */
	public static void toBeJson(List list, int total) throws Exception {
		JsonConfig myJsonConfig = new JsonConfig();
//		myJsonConfig.setJsonPropertyFilter(new PropertyFilter() {
//
//			@Override
//			public boolean apply(Object source, String name, Object value) {
//				// TODO Auto-generated method stub
//				if (name.equals("users"))
//					return true;
//				else
//					return false;
//			}
//		});
		HttpServletResponse myResponse = ServletActionContext.getResponse();
		JSONObject myJsonObject = new JSONObject();
		myJsonObject.accumulate("total", total, myJsonConfig);
		myJsonObject.accumulate("rows", list, myJsonConfig);
		myResponse.setCharacterEncoding("UTF-8");
		myResponse.getWriter().write(myJsonObject.toString());
	}


	/**
	 * ���������ڱ���ʵ�н�����ַ�������ת��Ϊjson���ͷ��ص�ǰ̨ 
	 * @param result
	 * @throws Exception
	 */
	public static void toBeJsonResult(String result) throws Exception {
		JsonConfig myJsonConfig = new JsonConfig();
		HttpServletResponse myResponse = ServletActionContext.getResponse();
		JSONObject myJsonObject = new JSONObject();
		myJsonObject.accumulate("result", result, myJsonConfig);
		myResponse.setCharacterEncoding("UTF-8");
		myResponse.getWriter().write(myJsonObject.toString());
	}
	
	
	
}
