package com.logistics.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.logistics.domain.User;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportToExcel {

	public void createExcel(OutputStream os, List<User> userList,String []title)
			throws IOException, RowsExceededException, WriteException {
		// ����������
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		
		// �����µ�һҳ
		WritableSheet sheet = workbook.createSheet("�û���Ϣ", 0);
		
		//������ͷ
		Label titleLabel;
		for (int i = 0; i < title.length; i++) {
			//����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
			titleLabel=new Label(i, 0, title[i]);
			//��������ӽ�������ҳ��
			sheet.addCell(titleLabel);
		}
		
	
		//���û���Ϣ���뵽��������
		
		for (int i = 0; i < userList.size(); i++) {
			int index=0;
			sheet.addCell(new Label(index++, i+1, userList.get(i).getUid()+""));
			sheet.addCell(new Label(index++, i+1, userList.get(i).getUname()));
			sheet.addCell(new Label(index++, i+1, userList.get(i).getUpassword()));
			sheet.addCell(new Label(index++, i+1, userList.get(i).getRid()+""));
		}
		

		// �Ѵ���������д�뵽������У����ر������
		workbook.write();
		workbook.close();
		os.close();
	}
}
