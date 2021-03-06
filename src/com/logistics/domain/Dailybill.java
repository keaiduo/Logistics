package com.logistics.domain;

// Generated 2015-7-19 17:33:19 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Dailybill generated by hbm2java
 */
public class Dailybill implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int did;
	private Date ddate;
	private String dszqk;
	private String dfkzw;
	private String dorder;
	private String dreason;
	private Integer damount;
	private Integer dcard;
	private String dpayment;
	private String dbroker;
	private String dremarks;

	public Dailybill() {
	}

	public Dailybill(int did, Date ddate, String dszqk, String dreason) {
		this.did = did;
		this.ddate = ddate;
		this.dszqk = dszqk;
		this.dreason = dreason;
	}

	public Dailybill(int did, Date ddate, String dszqk, String dfkzw,
			String dorder, String dreason, Integer damount, Integer dcard,
			String dpayment, String dbroker, String dremarks) {
		this.did = did;
		this.ddate = ddate;
		this.dszqk = dszqk;
		this.dfkzw = dfkzw;
		this.dorder = dorder;
		this.dreason = dreason;
		this.damount = damount;
		this.dcard = dcard;
		this.dpayment = dpayment;
		this.dbroker = dbroker;
		this.dremarks = dremarks;
	}

	public int getDid() {
		return this.did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public Date getDdate() {
		return this.ddate;
	}

	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}

	public String getDszqk() {
		return this.dszqk;
	}

	public void setDszqk(String dszqk) {
		this.dszqk = dszqk;
	}

	public String getDfkzw() {
		return this.dfkzw;
	}

	public void setDfkzw(String dfkzw) {
		this.dfkzw = dfkzw;
	}

	public String getDorder() {
		return this.dorder;
	}

	public void setDorder(String dorder) {
		this.dorder = dorder;
	}

	public String getDreason() {
		return this.dreason;
	}

	public void setDreason(String dreason) {
		this.dreason = dreason;
	}

	public Integer getDamount() {
		return this.damount;
	}

	public void setDamount(Integer damount) {
		this.damount = damount;
	}

	public Integer getDcard() {
		return this.dcard;
	}

	public void setDcard(Integer dcard) {
		this.dcard = dcard;
	}

	public String getDpayment() {
		return this.dpayment;
	}

	public void setDpayment(String dpayment) {
		this.dpayment = dpayment;
	}

	public String getDbroker() {
		return this.dbroker;
	}

	public void setDbroker(String dbroker) {
		this.dbroker = dbroker;
	}

	public String getDremarks() {
		return this.dremarks;
	}

	public void setDremarks(String dremarks) {
		this.dremarks = dremarks;
	}

}
