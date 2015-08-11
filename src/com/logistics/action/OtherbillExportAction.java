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

import com.logistics.domain.Otherbill;
import com.logistics.service.IOtherbillService;
import com.logistics.util.OtherbillExportToExcel;
import com.opensymphony.xwork2.ActionSupport;

public class OtherbillExportAction extends ActionSupport implements ServletContextAware,
ServletRequestAware, SessionAware, ServletResponseAware{

	/**
	 * 日常数据表导出
	 */
	private static final long serialVersionUID = 1L;
	private IOtherbillService otherbillService;
	private OtherbillExportToExcel otherbillExportToExcel;
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
		//按照所选日期导出
		List<Otherbill> otherbillList = otherbillService.searchByDate(str1, str2);
		//设置title
		String[] titles = {"序号","日期","公司","业务状况","数量","事由","利润","经手人"};
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		otherbillExportToExcel.createExcel(os, otherbillList, titles);
		byte[] filecontent = os.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(filecontent);
		excelStream = is;
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date); 
		fileName = "其他业务清单导出"+time+".xls";
		fileName=new String(fileName.getBytes(), "ISO8859-1");      
		return "excel";
	}

	public IOtherbillService getOtherbillService() {
		return otherbillService;
	}

	public void setOtherbillService(IOtherbillService otherbillService) {
		this.otherbillService = otherbillService;
	}

	public OtherbillExportToExcel getOtherbillExportToExcel() {
		return otherbillExportToExcel;
	}

	public void setOtherbillExportToExcel(
			OtherbillExportToExcel otherbillExportToExcel) {
		this.otherbillExportToExcel = otherbillExportToExcel;
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
