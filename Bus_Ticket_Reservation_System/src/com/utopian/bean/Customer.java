package com.utopian.bean;

public class Customer {

	private int cId;
	private String cName;
	private String cAddr;
	private String cMob;
	private String cEmail;
	private String cPass;

	public Customer() {
	}

	public Customer(int cId, String cName, String cAddr, String cMob, String cEmail, String cPass) {
		this.cId = cId;
		this.cName = cName;
		this.cAddr = cAddr;
		this.cMob = cMob;
		this.cEmail = cEmail;
		this.cPass = cPass;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcAddr() {
		return cAddr;
	}

	public void setcAddr(String cAddr) {
		this.cAddr = cAddr;
	}

	public String getcMob() {
		return cMob;
	}

	public void setcMob(String cMob) {
		this.cMob = cMob;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcPass() {
		return cPass;
	}

	public void setcPass(String cPass) {
		this.cPass = cPass;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cAddr=" + cAddr + ", cMob=" + cMob + ", cEmail="
				+ cEmail + ", cPass=" + cPass + "]";
	}

}
