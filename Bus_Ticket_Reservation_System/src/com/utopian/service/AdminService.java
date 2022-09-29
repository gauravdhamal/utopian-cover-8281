package com.utopian.service;

import java.util.List;

import com.utopian.bean.Bus;
import com.utopian.bean.CustomerDTO;
import com.utopian.dao.BusDao;
import com.utopian.dao.BusDaoImpl;
import com.utopian.dao.CustomerDao;
import com.utopian.dao.CustomerDaoImpl;
import com.utopian.exception.BusException;

public class AdminService {

	public static void viewBuses() {

		BusDao bDao = new BusDaoImpl();

		try {
			List<Bus> buses = bDao.getAllBusDetails();

			buses.forEach(b -> {
//				System.out.println("Bus ID : " + b.getbId());
				System.out.println("Bus Name : " + b.getbName());
				System.out.println("Bus Route From : " + b.getbRoute_From());
				System.out.println("Bus Route To : " + b.getbRoute_To());
				System.out.println("Bus type : " + b.getbType());
				System.out.println("Available seats : " + b.getbSeats());
//				System.out.println("Arrival Date & Time : " + b.getbArriDateTime());
//				System.out.println("Departure Date & Time : " + b.getbDeptDateTime());
				System.out.println("------------------------------");
			});

		} catch (BusException e) {
			System.out.println(e.getMessage());
		}

	}

	public static String book(String source, String destination, int tickets) {
		String msg = "Booking failed.";

		BusDao bDao = new BusDaoImpl();

		try {
			msg = bDao.bookTicket(source, destination, tickets);
		} catch (BusException e) {
			msg = e.getMessage();
		}

		return msg;
	}

	public static void addCustomerRecord(String source, String destination, String mobile, int selectedSeats) {

		CustomerDao cDao = new CustomerDaoImpl();

		CustomerDTO customer = cDao.getCustomer(source, destination, mobile, selectedSeats);

		cDao.addCustomer(customer);
	}

}
