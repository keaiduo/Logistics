package com.logistics.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.logistics.vo.Profit;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class ProfitExportToExcel {
	public void createExcel(OutputStream os, List<Profit> profitList,String []title)
			throws IOException, RowsExceededException, WriteException {
		// ����������
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		
		// �����µ�һҳ
		WritableSheet sheet = workbook.createSheet("�����", 0);
		
		//������ͷ
		Label titleLabel;
		for (int i = 0; i < title.length; i++) {
			//����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
			titleLabel=new Label(i, 0, title[i]);
			//��������ӽ�������ҳ��
			sheet.addCell(titleLabel);
		}
		
	
		//���û���Ϣ���뵽��������
		
		for (int i = 0; i < profitList.size(); i++) {
			int index=0;
			//���
			sheet.addCell(new Label(index++,i+1,i+1+""));
			//�ͻ�����
			sheet.addCell(new Label(index++,i+1,profitList.get(i).getClientno()+""));
			sheet.addCell(new Label(index++,i+1,profitList.get(i).getClientno()+""));
			//��˾����
			sheet.addCell(new Label(index++,i+1,profitList.get(i).getOrderno()));
			//��������
			sheet.addCell(new Label(index++,i+1, profitList.get(i).getStartdate()+""));
			//����
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getNumber()+""));
			//����
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getQuantity()+""));
			//��λ
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getUnit()));
			//ʼ����
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getStartlocation()));
			//�ջ���λ
			sheet.addCell(new Label(index++, i+1,  profitList.get(i).getEndcompany()));
			//����
			sheet.addCell(new Label(index++,i+1, profitList.get(i).getChannel()));
			//�ջ���ַ
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getEndlocation()));
			//�˷��ܶ�
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getTotalfee()+""));
			//����ɱ�
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getTthcb()+profitList.get(i).getTthf()));
			//ר�߷���
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getTzxf()+""));
			//�ͻ���
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getTshf()+""));
			//�ɱ��ϼ� = ����ɱ�+ר�߷���+�ͻ���
			Double cbhj = Double.parseDouble(profitList.get(i).getTthcb())+profitList.get(i).getTthf()+profitList.get(i).getTzxf()+profitList.get(i).getTshf();
			sheet.addCell(new Label(index++,i+1, cbhj+""));
			//ë����  = �˷��ܶ� - �ɱ��ϼ�
			Double myr =  profitList.get(i).getTotalfee() - cbhj;
			sheet.addCell(new Label(index++,i+1,myr+""));
			//��ע
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getRemarks()));
			
		}	

		// �Ѵ���������д�뵽������У����ر������
		workbook.write();
		workbook.close();
		os.close();
	}

}














