package com.logistics.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import com.logistics.domain.User;
import com.logistics.service.IUserService;
import com.logistics.util.ExportToExcel;
import com.opensymphony.xwork2.ActionSupport;

public class DataExportAction extends ActionSupport {

	/**
	 * ���ݵ���action
	 */
	private static final long serialVersionUID = 1L;

	private IUserService userService;

	private ExportToExcel exportUtil;

	private String fileName;

	private InputStream excelStream;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<User> myUserList = userService.selectAllUser();
		String[] titles = { "�û���ʶ", "�û���", "����", "rid" };

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		exportUtil.createExcel(os, myUserList, titles);
		byte[] fileContent = os.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
		excelStream = is; // �ļ���
		fileName = "�û���Ϣ����.xls";
		//������Ҫע����Ҫ����ת�룬����ᵼ�������ļ����޷���ʾ
		fileName=new String(fileName.getBytes(), "ISO8859-1");           
		return "excel";
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ExportToExcel getExportUtil() {
		return exportUtil;
	}

	public void setExportUtil(ExportToExcel exportUtil) {
		this.exportUtil = exportUtil;
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

}
