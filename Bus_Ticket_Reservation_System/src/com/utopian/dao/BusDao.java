package com.utopian.dao;

import java.util.List;

import com.utopian.bean.Bus;
import com.utopian.exception.BusException;

public interface BusDao {

	public String registerNewBus(int bId, String bName, String bRoute_From, String bRoute_To, String bType, int bSeats,
			String bDeptDateTime, String bArriDateTime, int bAdminId, String bConPerName, String bConPerMob);

	public List<Bus> getEmptyBuses() throws BusException;

	public String removeBusById(int bId);

	public String registerNewBus2(Bus bus);

	public List<Bus> getAllBusDetails() throws BusException;

	public Bus bookTicket(String source, String destination, int tickets, String mobileNo) throws BusException;

	public int noOfTicketsAval(String source, String destination);

	public Bus getBus(String source, String destination);

	public String cancelTicket(int refId);

	public String updateBusSeats(int bId, int freeSeats);

	public int getBusId(int refId);

	public int getReleasedSeats(int refId);

	public int checkTime(String source, String destination);
	
	public String getDeptTime(String source, String destination);
}
