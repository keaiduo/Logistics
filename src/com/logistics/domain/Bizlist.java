package com.logistics.domain;

// Generated 2015-7-19 17:33:19 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Bizlist generated by hbm2java
 */
public class Bizlist implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int bid;
	private String orderno;
	private String clientno;
	private String companyname;
	private Date startdate;
	private Integer number;
	private Double quantity;
	private String unit;
	private String startlocation;
	private String endcompany;
	private String channel;
	private String endlocation;
	private String receiver;
	private String telephone;
	private Double totalfee;

	public Bizlist() {
	}

	public Bizlist(int bid, String orderno) {
		this.bid = bid;
		this.orderno = orderno;
	}

	public Bizlist(int bid, String orderno, String clientno,
			String companyname, Date startdate, Integer number,
			Double quantity, String unit, String startlocation,
			String endcompany, String channel, String endlocation,
			String receiver, String telephone, Double totalfee) {
		this.bid = bid;
		this.orderno = orderno;
		this.clientno = clientno;
		this.companyname = companyname;
		this.startdate = startdate;
		this.number = number;
		this.quantity = quantity;
		this.unit = unit;
		this.startlocation = startlocation;
		this.endcompany = endcompany;
		this.channel = channel;
		this.endlocation = endlocation;
		this.receiver = receiver;
		this.telephone = telephone;
		this.totalfee = totalfee;
	}

	public int getBid() {
		return this.bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getOrderno() {
		return this.orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getClientno() {
		return this.clientno;
	}

	public void setClientno(String clientno) {
		this.clientno = clientno;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStartlocation() {
		return this.startlocation;
	}

	public void setStartlocation(String startlocation) {
		this.startlocation = startlocation;
	}

	public String getEndcompany() {
		return this.endcompany;
	}

	public void setEndcompany(String endcompany) {
		this.endcompany = endcompany;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getEndlocation() {
		return this.endlocation;
	}

	public void setEndlocation(String endlocation) {
		this.endlocation = endlocation;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Double getTotalfee() {
		return this.totalfee;
	}

	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}

	@Override
	public String toString() {
		return "Bizlist [bid=" + bid + ", orderno=" + orderno + ", clientno="
				+ clientno + ", companyname=" + companyname + ", startdate="
				+ startdate + ", number=" + number + ", quantity=" + quantity
				+ ", unit=" + unit + ", startlocation=" + startlocation
				+ ", endcompany=" + endcompany + ", channel=" + channel
				+ ", endlocation=" + endlocation + ", receiver=" + receiver
				+ ", telephone=" + telephone + ", totalfee=" + totalfee + "]";
	}

}
