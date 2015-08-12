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





import com.logistics.domain.Bizlist;
import com.logistics.service.IBizlistService;
import com.logistics.util.BizlistExportToExcel;
import com.opensymphony.xwork2.ActionSupport;

public class BizlistExportAction extends ActionSupport implements ServletContextAware,
ServletRequestAware, SessionAware, ServletResponseAware{

	/**
	 * �ճ����ݱ���
	 */
	private static final long serialVersionUID = 1L;
	private IBizlistService bizlistService;
	private BizlistExportToExcel bizlistExportToExcel;
	private String fileName;
	private InputStream excelStream;
	
	private ServletContext servletContext;
	private Map<String,Object> session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����BizlistExportAction����");
		String str1 = request.getParameter("companyname");
		String str2 = request.getParameter("startDate");
		String str3 = request.getParameter("endDate");
		System.out.println("str1"+str1+">>>str2"+str2+">>>str3"+str3);
		List<Bizlist> bizlist = bizlistService.exportby(str1, str2, str3);
		//����title
		String[] titles = {"���","�ͻ�����","��˾����","��������","����","����","��λ","ʼ����","�ջ���λ","����","�ջ���ַ","�ջ���","�ջ�����ϵ��ʽ","�˷��ܶ�","��ע"};
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		bizlistExportToExcel.createExcel(os, bizlist, titles);
		byte[] filecontent = os.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(filecontent);
		excelStream = is;
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date); 
		fileName = str1+"��˾ҵ���嵥"+time+".xls";
		fileName=new String(fileName.getBytes(), "ISO8859-1");      
		return "excel";
	}

	public IBizlistService getBizlistService() {
		return bizlistService;
	}

	public void setBizlistService(IBizlistService bizlistService) {
		this.bizlistService = bizlistService;
	}

	public BizlistExportToExcel getBizlistExportToExcel() {
		return bizlistExportToExcel;
	}

	public void setBizlistExportToExcel(BizlistExportToExcel bizlistExportToExcel) {
		this.bizlistExportToExcel = bizlistExportToExcel;
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
