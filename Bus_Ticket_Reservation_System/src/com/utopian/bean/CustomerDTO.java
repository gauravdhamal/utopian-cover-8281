package com.utopian.bean;

public class CustomerDTO {

	private String cMob;
	private int refId;
	private int bId;
	private String bName;
	private String bRoute_From;
	private String bRoute_To;
	private String bType;
	private int bookedSeats;
	private String bDeptDateTime;
	private String bArriDateTime;
	private int bAdminId;
	private String bConPerName;
	private String bConPerMob;

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDTO(String cMob, int refId, int bId, String bName, String bRoute_From, String bRoute_To,
			String bType, int bookedSeats, String bDeptDateTime, String bArriDateTime, int bAdminId, String bConPerName,
			String bConPerMob) {
		super();
		this.cMob = cMob;
		this.refId = refId;
		this.bId = bId;
		this.bName = bName;
		this.bRoute_From = bRoute_From;
		this.bRoute_To = bRoute_To;
		this.bType = bType;
		this.bookedSeats = bookedSeats;
		this.bDeptDateTime = bDeptDateTime;
		this.bArriDateTime = bArriDateTime;
		this.bAdminId = bAdminId;
		this.bConPerName = bConPerName;
		this.bConPerMob = bConPerMob;
	}

	public String getcMob() {
		return cMob;
	}

	public void setcMob(String cMob) {
		this.cMob = cMob;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
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

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
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
		return "CustomerDTO [cMob=" + cMob + ", refId=" + refId + ", bId=" + bId + ", bName=" + bName + ", bRoute_From="
				+ bRoute_From + ", bRoute_To=" + bRoute_To + ", bType=" + bType + ", bookedSeats=" + bookedSeats
				+ ", bDeptDateTime=" + bDeptDateTime + ", bArriDateTime=" + bArriDateTime + ", bAdminId=" + bAdminId
				+ ", bConPerName=" + bConPerName + ", bConPerMob=" + bConPerMob + "]";
	}

}
