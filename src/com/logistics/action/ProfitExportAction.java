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

import com.logistics.domain.Profit;
import com.logistics.util.ProfitExportToExcel;
import com.logistics.util.ProfitExportUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ProfitExportAction extends ActionSupport implements ServletContextAware,
ServletRequestAware, SessionAware, ServletResponseAware{

	/**
	 * 日常数据表导出
	 */
	private static final long serialVersionUID = 1L;
	private ProfitExportToExcel profitExportToExcel;
	private ProfitExportUtil profitExportUtil;
	private String fileName;
	private InputStream excelStream;
	
	private ServletContext servletContext;
	private Map<String,Object> session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String companyName = request.getParameter("companyname");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
	
		System.out.println("str1"+companyName+">>>str2"+startDate+">>>str3"+endDate);
		List<Profit> profit = profitExportUtil.getProfit(companyName, startDate, endDate);
		//设置title
		String[] titles = {"序号","客户单号","公司单号","发货日期","件数","数量","单位","始发地","收货单位","渠道","收货地址","运费总额","提货成本","专线费用","送货费","成本合计","毛利润","备注"};
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		profitExportToExcel.createExcel(os, profit, titles);
		byte[] filecontent = os.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(filecontent);
		excelStream = is;
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date); 
		fileName = companyName+"公司利润清单"+time+".xls";
		fileName=new String(fileName.getBytes(), "ISO8859-1");      
		return "excel";
	}







	public ProfitExportToExcel getProfitExportToExcel() {
		return profitExportToExcel;
	}



	public void setProfitExportToExcel(ProfitExportToExcel profitExportToExcel) {
		this.profitExportToExcel = profitExportToExcel;
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







	public ProfitExportUtil getProfitExportUtil() {
		return profitExportUtil;
	}







	public void setProfitExportUtil(ProfitExportUtil profitExportUtil) {
		this.profitExportUtil = profitExportUtil;
	}
	
	
	

}
