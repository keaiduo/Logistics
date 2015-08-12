package com.logistics.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.logistics.domain.Bizlist;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class BizlistExportToExcel {
	public void createExcel(OutputStream os, List<Bizlist> bizlistList,String []title)
			throws IOException, RowsExceededException, WriteException {
		// ����������
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		
		// �����µ�һҳ
		WritableSheet sheet = workbook.createSheet("ҵ���嵥", 0);
		
		//������ͷ
		Label titleLabel;
		for (int i = 0; i < title.length; i++) {
			//����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
			titleLabel=new Label(i, 0, title[i]);
			//��������ӽ�������ҳ��
			sheet.addCell(titleLabel);
		}
		
	
		//���û���Ϣ���뵽��������
		
		for (int i = 0; i < bizlistList.size(); i++) {
			int index=0;
			//���
			sheet.addCell(new Label(index++,i+1,i+1+""));
			//�ͻ�����
			sheet.addCell(new Label(index++,i+1,bizlistList.get(i).getClientno()+""));
			//��˾����
			sheet.addCell(new Label(index++,i+1,bizlistList.get(i).getOrderno()));
			//��������
			sheet.addCell(new Label(index++,i+1,bizlistList.get(i).getStartdate()+""));
			//����
			sheet.addCell(new Label(index++, i+1, bizlistList.get(i).getNumber()+""));
			//����
			sheet.addCell(new Label(index++, i+1, bizlistList.get(i).getQuantity()+""));
			//��λ
			sheet.addCell(new Label(index++, i+1, bizlistList.get(i).getUnit()));
			//ʼ����
			sheet.addCell(new Label(index++, i+1, bizlistList.get(i).getStartlocation()));
			//�ջ���λ
			sheet.addCell(new Label(index++, i+1,  bizlistList.get(i).getEndcompany()));
			//����
			sheet.addCell(new Label(index++,i+1,bizlistList.get(i).getChannel()));
			//�ջ���ַ
			sheet.addCell(new Label(index++, i+1, bizlistList.get(i).getEndlocation()));
			//�ջ���
			sheet.addCell(new Label(index++, i+1, bizlistList.get(i).getReceiver()));
			//�ջ�����ϵ��ʽ
			sheet.addCell(new Label(index++, i+1, bizlistList.get(i).getTelephone()));
			//�˷��ܶ�
			sheet.addCell(new Label(index++, i+1, bizlistList.get(i).getTotalfee()+""));
			//��ע
			sheet.addCell(new Label(index++, i+1, bizlistList.get(i).getRemarks()));
		}	

		// �Ѵ���������д�뵽������У����ر������
		workbook.write();
		workbook.close();
		os.close();
	}

}














