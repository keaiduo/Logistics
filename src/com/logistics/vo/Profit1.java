package com.logistics.vo;

import java.util.Date;

public class Profit1 implements java.io.Serializable{

	/**
	 * 导出利润表所使用类
	 */
	private static final long serialVersionUID = 1L;
	
	private int bid;              //序号
	private String orderno;		  //公司单号
	private String clientno;	  //客户单号
	private String companyname;	  //公司名称
	private Date startdate;	      //发货日期
	private Integer number;	      //件数
	private Double quantity;	  //数量
	private String unit;	      //单位
	private String startlocation; //始发地
	private String endcompany;	  //收货单位
	private String channel;	      //渠道
	private String endlocation;	  //收货地址
	private String receiver;	  //收货人
	private String telephone;	  //收货人电话
	private Double totalfee;	  //运费总额
	private String remarks;	      //备注
	
	private int tid;
	private String tno;
	private String tname;
	private String taddr;
	private String tlxt;
	private String tlxdh;
	private String tchdh;
	private Double tprice;
	private Double tzxf;
	private Double tshf;
	private Double tthf;
	private Double tcbf;
	private String tthch;
	private String tthr;
	private String tsjdh;
	private String tthcb;
	private String tgsdh;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getClientno() {
		return clientno;
	}
	public void setClientno(String clientno) {
		this.clientno = clientno;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getStartlocation() {
		return startlocation;
	}
	public void setStartlocation(String startlocation) {
		this.startlocation = startlocation;
	}
	public String getEndcompany() {
		return endcompany;
	}
	public void setEndcompany(String endcompany) {
		this.endcompany = endcompany;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getEndlocation() {
		return endlocation;
	}
	public void setEndlocation(String endlocation) {
		this.endlocation = endlocation;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Double getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTaddr() {
		return taddr;
	}
	public void setTaddr(String taddr) {
		this.taddr = taddr;
	}
	public String getTlxt() {
		return tlxt;
	}
	public void setTlxt(String tlxt) {
		this.tlxt = tlxt;
	}
	public String getTlxdh() {
		return tlxdh;
	}
	public void setTlxdh(String tlxdh) {
		this.tlxdh = tlxdh;
	}
	public String getTchdh() {
		return tchdh;
	}
	public void setTchdh(String tchdh) {
		this.tchdh = tchdh;
	}
	public Double getTprice() {
		return tprice;
	}
	public void setTprice(Double tprice) {
		this.tprice = tprice;
	}
	public Double getTzxf() {
		return tzxf;
	}
	public void setTzxf(Double tzxf) {
		this.tzxf = tzxf;
	}
	public Double getTshf() {
		return tshf;
	}
	public void setTshf(Double tshf) {
		this.tshf = tshf;
	}
	public Double getTthf() {
		return tthf;
	}
	public void setTthf(Double tthf) {
		this.tthf = tthf;
	}
	public Double getTcbf() {
		return tcbf;
	}
	public void setTcbf(Double tcbf) {
		this.tcbf = tcbf;
	}
	public String getTthch() {
		return tthch;
	}
	public void setTthch(String tthch) {
		this.tthch = tthch;
	}
	public String getTthr() {
		return tthr;
	}
	public void setTthr(String tthr) {
		this.tthr = tthr;
	}
	public String getTsjdh() {
		return tsjdh;
	}
	public void setTsjdh(String tsjdh) {
		this.tsjdh = tsjdh;
	}
	public String getTthcb() {
		return tthcb;
	}
	public void setTthcb(String tthcb) {
		this.tthcb = tthcb;
	}
	public String getTgsdh() {
		return tgsdh;
	}
	public void setTgsdh(String tgsdh) {
		this.tgsdh = tgsdh;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
