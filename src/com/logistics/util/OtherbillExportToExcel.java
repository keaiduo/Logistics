package com.logistics.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.logistics.domain.Otherbill;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;



public class OtherbillExportToExcel {
	public void createExcel(OutputStream os, List<Otherbill> otherbillList,String []title)
			throws IOException, RowsExceededException, WriteException {
		// ����������
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		
		// �����µ�һҳ
		WritableSheet sheet = workbook.createSheet("����ҵ���嵥", 0);
		
		//������ͷ
		Label titleLabel;
		for (int i = 0; i < title.length; i++) {
			//����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
			titleLabel=new Label(i, 0, title[i]);
			//��������ӽ�������ҳ��
			sheet.addCell(titleLabel);
		}
		
	
		//���û���Ϣ���뵽��������
		
		for (int i = 0; i < otherbillList.size(); i++) {
			int index=0;
			//���
			sheet.addCell(new Label(index++,i+1,i+1+""));
			//����
			sheet.addCell(new Label(index++,i+1,otherbillList.get(i).getOdate()+""));
			//��˾
			sheet.addCell(new Label(index++,i+1,otherbillList.get(i).getOcompany()));
			//ҵ��״��
			sheet.addCell(new Label(index++,i+1,otherbillList.get(i).getObiz()));
			//����
			sheet.addCell(new Label(index++, i+1, otherbillList.get(i).getOquantity()));
			//����
			sheet.addCell(new Label(index++, i+1, otherbillList.get(i).getOreason()));
			//����
			sheet.addCell(new Label(index++, i+1, otherbillList.get(i).getOprofit()+""));
			//������
			sheet.addCell(new Label(index++, i+1, otherbillList.get(i).getObroker()));
		}	

		// �Ѵ���������д�뵽������У����ر������
		workbook.write();
		workbook.close();
		os.close();
	}

}














