package com.utopian.bean;

public class Bus {

	private int bId;
	private String bName;
	private String bRoute_From;
	private String bRoute_To;
	private String bType;
	private int bSeats;
	private String bDeptDateTime;
	private String bArriDateTime;
	private int bAdminId;
	private String bConPerName;
	private String bConPerMob;

	public Bus() {
	}

	public Bus(int bId, String bName, String bRoute_From, String bRoute_To, String bType, int bSeats,
			String bDeptDateTime, String bArriDateTime, int bAdminId, String bConPerName, String bConPerMob) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bRoute_From = bRoute_From;
		this.bRoute_To = bRoute_To;
		this.bType = bType;
		this.bSeats = bSeats;
		this.bDeptDateTime = bDeptDateTime;
		this.bArriDateTime = bArriDateTime;
		this.bAdminId = bAdminId;
		this.bConPerName = bConPerName;
		this.bConPerMob = bConPerMob;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbRoute_From() {
		return bRoute_From;
	}

	public void setbRoute_From(String bRoute_From) {
		this.bRoute_From = bRoute_From;
	}

	public String getbRoute_To() {
		return bRoute_To;
	}

	public void setbRoute_To(String bRoute_To) {
		this.bRoute_To = bRoute_To;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public int getbSeats() {
		return bSeats;
	}

	public void setbSeats(int bSeats) {
		this.bSeats = bSeats;
	}

	public String getbDeptDateTime() {
		return bDeptDateTime;
	}

	public void setbDeptDateTime(String bDeptDateTime) {
		this.bDeptDateTime = bDeptDateTime;
	}

	public String getbArriDateTime() {
		return bArriDateTime;
	}

	public void setbArriDateTime(String bArriDateTime) {
		this.bArriDateTime = bArriDateTime;
	}

	public int getbAdminId() {
		return bAdminId;
	}

	public void setbAdminId(int bAdminId) {
		this.bAdminId = bAdminId;
	}

	public String getbConPerName() {
		return bConPerName;
	}

	public void setbConPerName(String bConPerName) {
		this.bConPerName = bConPerName;
	}

	public String getbConPerMob() {
		return bConPerMob;
	}

	public void setbConPerMob(String bConPerMob) {
		this.bConPerMob = bConPerMob;
	}

	@Override
	public String toString() {
		return "Bus [bId=" + bId + ", bName=" + bName + ", bRoute_From=" + bRoute_From + ", bRoute_To=" + bRoute_To
				+ ", bType=" + bType + ", bSeats=" + bSeats + ", bDeptDateTime=" + bDeptDateTime + ", bArriDateTime="
				+ bArriDateTime + ", bAdminId=" + bAdminId + ", bConPerName=" + bConPerName + ", bConPerMob="
				+ bConPerMob + "]";
	}

}
