package com.utopian.bean;

public class Administrator {

	private String aName;
	private String aAddr;
	private String aEmail;
	private String aPass;

	public Administrator() {
	}

	public Administrator(String aName, String aAddr, String aEmail, String aPass) {
		super();
		this.aName = aName;
		this.aAddr = aAddr;
		this.aEmail = aEmail;
		this.aPass = aPass;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaAddr() {
		return aAddr;
	}

	public void setaAddr(String aAddr) {
		this.aAddr = aAddr;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaPass() {
		return aPass;
	}

	public void setaPass(String aPass) {
		this.aPass = aPass;
	}

	@Override
	public String toString() {
		return "Administrator [aName=" + aName + ", aAddr=" + aAddr + ", aEmail=" + aEmail + ", aPass=" + aPass + "]";
	}

}
