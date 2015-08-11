package com.logistics.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.logistics.domain.Dailybill;

public class DailybillExportToExcel {
	public void createExcel(OutputStream os, List<Dailybill> dailybillList,String []title)
			throws IOException, RowsExceededException, WriteException {
		// ����������
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		
		// �����µ�һҳ
		WritableSheet sheet = workbook.createSheet("��֧��", 0);
		
		//������ͷ
		Label titleLabel;
		for (int i = 0; i < title.length; i++) {
			//����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
			titleLabel=new Label(i, 0, title[i]);
			//��������ӽ�������ҳ��
			sheet.addCell(titleLabel);
		}
		
	
		//���û���Ϣ���뵽��������
		
		for (int i = 0; i < dailybillList.size(); i++) {
			int index=0;
			//���
			sheet.addCell(new Label(index++,i+1,i+1+""));
			//����
			sheet.addCell(new Label(index++,i+1,dailybillList.get(i).getDdate()+""));
			//��֧���
			sheet.addCell(new Label(index++,i+1,dailybillList.get(i).getDszqk()));
			//���λ
			sheet.addCell(new Label(index++,i+1,dailybillList.get(i).getDfkzw()));
			//����
			sheet.addCell(new Label(index++, i+1, dailybillList.get(i).getDorder()+""));
			//����
			sheet.addCell(new Label(index++, i+1, dailybillList.get(i).getDreason()));
			//���
			sheet.addCell(new Label(index++, i+1, dailybillList.get(i).getDamount()+""));
			//�Ϳ�
			sheet.addCell(new Label(index++, i+1, dailybillList.get(i).getDcard()+""));
			//�ϼ�
			sheet.addCell(new Label(index++, i+1,  (dailybillList.get(i).getDamount()+dailybillList.get(i).getDcard()+"")));
			//���ʽ
			sheet.addCell(new Label(index++,i+1,dailybillList.get(i).getDpayment()));
			//������
			sheet.addCell(new Label(index++, i+1, dailybillList.get(i).getDbroker()));
			//��ע
			sheet.addCell(new Label(index++, i+1, dailybillList.get(i).getDremarks()));
		}	

		// �Ѵ���������д�뵽������У����ر������
		workbook.write();
		workbook.close();
		os.close();
	}

}














