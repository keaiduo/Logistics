package com.logistics.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.logistics.domain.Dailybill;
import com.logistics.service.IDailybillService;
import com.logistics.util.DailybillExportToExcel;
import com.opensymphony.xwork2.ActionSupport;

public class DailybillExportAction extends ActionSupport implements ServletContextAware,
ServletRequestAware, SessionAware, ServletResponseAware{

	/**
	 * 日常数据表导出
	 */
	private static final long serialVersionUID = 1L;
	private IDailybillService dailybillService;
	private DailybillExportToExcel dailybillExportToExcel;
	private String fileName;
	private InputStream excelStream;
	
	private ServletContext servletContext;
	private Map<String,Object> session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入dailybillExportAction方法");
		String str1 = request.getParameter("startDate");
		String str2 = request.getParameter("endDate");
		System.out.println("str1"+str1+">>>str2"+str2);
//		List<Dailybill> dailybillList = dailybillService.findAll();
		List<Dailybill> dailybillList = dailybillService.searchByDate(str1, str2);
		//设置title
		String[] titles = {"序号","日期","收支情况","付款单位","单号","事由","金额","油卡","合计","付款方式","经手人","备注"};
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		dailybillExportToExcel.createExcel(os, dailybillList, titles);
		byte[] filecontent = os.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(filecontent);
		excelStream = is;
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date); 
		fileName = "日常现金账导出"+time+".xls";
		fileName=new String(fileName.getBytes(), "ISO8859-1");      
		return "excel";
	}
	public IDailybillService getDailybillService() {
		return dailybillService;
	}
	public void setDailybillService(IDailybillService dailybillService) {
		this.dailybillService = dailybillService;
	}
	public DailybillExportToExcel getDailybillExportToExcel() {
		return dailybillExportToExcel;
	}
	public void setDailybillExportToExcel(
			DailybillExportToExcel dailybillExportToExcel) {
		this.dailybillExportToExcel = dailybillExportToExcel;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;

	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.servletContext = servletContext;

	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
	
	
	

}
