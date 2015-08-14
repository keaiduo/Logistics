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
		// 创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		
		// 创建新的一页
		WritableSheet sheet = workbook.createSheet("利润表", 0);
		
		//创建表头
		Label titleLabel;
		for (int i = 0; i < title.length; i++) {
			//创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
			titleLabel=new Label(i, 0, title[i]);
			//将标题添加进工作薄页面
			sheet.addCell(titleLabel);
		}
		
	
		//将用户信息输入到工作表表格
		
		for (int i = 0; i < profitList.size(); i++) {
			int index=0;
			//序号
			sheet.addCell(new Label(index++,i+1,i+1+""));
			//客户单号
			sheet.addCell(new Label(index++,i+1,profitList.get(i).getClientno()+""));
			sheet.addCell(new Label(index++,i+1,profitList.get(i).getClientno()+""));
			//公司单号
			sheet.addCell(new Label(index++,i+1,profitList.get(i).getOrderno()));
			//发货日期
			sheet.addCell(new Label(index++,i+1, profitList.get(i).getStartdate()+""));
			//件数
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getNumber()+""));
			//数量
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getQuantity()+""));
			//单位
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getUnit()));
			//始发地
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getStartlocation()));
			//收货单位
			sheet.addCell(new Label(index++, i+1,  profitList.get(i).getEndcompany()));
			//渠道
			sheet.addCell(new Label(index++,i+1, profitList.get(i).getChannel()));
			//收货地址
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getEndlocation()));
			//运费总额
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getTotalfee()+""));
			//提货成本
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getTthcb()+profitList.get(i).getTthf()));
			//专线费用
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getTzxf()+""));
			//送货费
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getTshf()+""));
			//成本合计 = 提货成本+专线费用+送货费
			Double cbhj = Double.parseDouble(profitList.get(i).getTthcb())+profitList.get(i).getTthf()+profitList.get(i).getTzxf()+profitList.get(i).getTshf();
			sheet.addCell(new Label(index++,i+1, cbhj+""));
			//毛利润  = 运费总额 - 成本合计
			Double myr =  profitList.get(i).getTotalfee() - cbhj;
			sheet.addCell(new Label(index++,i+1,myr+""));
			//备注
			sheet.addCell(new Label(index++, i+1, profitList.get(i).getRemarks()));
			
		}	

		// 把创建的内容写入到输出流中，并关闭输出流
		workbook.write();
		workbook.close();
		os.close();
	}

}














