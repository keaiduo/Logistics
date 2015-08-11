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
		// 创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		
		// 创建新的一页
		WritableSheet sheet = workbook.createSheet("其他业务清单", 0);
		
		//创建表头
		Label titleLabel;
		for (int i = 0; i < title.length; i++) {
			//创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
			titleLabel=new Label(i, 0, title[i]);
			//将标题添加进工作薄页面
			sheet.addCell(titleLabel);
		}
		
	
		//将用户信息输入到工作表表格
		
		for (int i = 0; i < otherbillList.size(); i++) {
			int index=0;
			//序号
			sheet.addCell(new Label(index++,i+1,i+1+""));
			//日期
			sheet.addCell(new Label(index++,i+1,otherbillList.get(i).getOdate()+""));
			//公司
			sheet.addCell(new Label(index++,i+1,otherbillList.get(i).getOcompany()));
			//业务状况
			sheet.addCell(new Label(index++,i+1,otherbillList.get(i).getObiz()));
			//数量
			sheet.addCell(new Label(index++, i+1, otherbillList.get(i).getOquantity()));
			//事由
			sheet.addCell(new Label(index++, i+1, otherbillList.get(i).getOreason()));
			//利润
			sheet.addCell(new Label(index++, i+1, otherbillList.get(i).getOprofit()+""));
			//经手人
			sheet.addCell(new Label(index++, i+1, otherbillList.get(i).getObroker()));
		}	

		// 把创建的内容写入到输出流中，并关闭输出流
		workbook.write();
		workbook.close();
		os.close();
	}

}














