package com.utopian.bean;

public class Bus {

	private int bId;
	private String bName;
	private String bRoute;
	private String bType;
	private int bSeats;
	private String bDeptDateTime;
	private String bArriDateTime;
	private int bAdminId;

	public Bus() {
	}

	public Bus(int bId, String bName, String bRoute, String bType, int bSeats, String bDeptDateTime,
			String bArriDateTime, int bAdminId) {
		this.bId = bId;
		this.bName = bName;
		this.bRoute = bRoute;
		this.bType = bType;
		this.bSeats = bSeats;
		this.bDeptDateTime = bDeptDateTime;
		this.bArriDateTime = bArriDateTime;
		this.bAdminId = bAdminId;
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

	public String getbRoute() {
		return bRoute;
	}

	public void setbRoute(String bRoute) {
		this.bRoute = bRoute;
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

	@Override
	public String toString() {
		return "Bus [bId=" + bId + ", bName=" + bName + ", bRoute=" + bRoute + ", bType=" + bType + ", bSeats=" + bSeats
				+ ", bDeptDateTime=" + bDeptDateTime + ", bArriDateTime=" + bArriDateTime + ", bAdminId=" + bAdminId
				+ "]";
	}

}
