package com.utopian.dao;

import com.utopian.bean.Bus;

public interface BusDao {
	
	public String registerNewBus(int bId, String bName, String bRoute, String bType, int bSeats, String bDeptDateTime,
			String bArriDateTime, int bAdminId);
	
	public String registerNewBus2(Bus bus);
	
}
