package com.utopian.dao;

import java.util.List;

import com.utopian.bean.Bus;
import com.utopian.exception.BusException;

public interface BusDao {

	public String registerNewBus(int bId, String bName, String bRoute_From, String bRoute_To, String bType, int bSeats,
			String bDeptDateTime, String bArriDateTime, int bAdminId);

	public String registerNewBus2(Bus bus);

	public List<Bus> getAllBusDetails() throws BusException;

	public String bookTicket(String source, String destination, int tickets) throws BusException;

	public int noOfTicketsAval(String source, String destination);

	public Bus getBus(String source, String destination);
}
