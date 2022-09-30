package com.utopian.service;

import java.util.List;
import java.util.Scanner;

import com.utopian.bean.Bus;
import com.utopian.bean.CustomerDTO;
import com.utopian.dao.BusDao;
import com.utopian.dao.BusDaoImpl;
import com.utopian.dao.CustomerDao;
import com.utopian.dao.CustomerDaoImpl;
import com.utopian.exception.BusException;
import com.utopian.exception.CustomerException;

public class AdminService {

	public static void viewBuses() {

		BusDao bDao = new BusDaoImpl();

		try {
			List<Bus> buses = bDao.getAllBusDetails();

			buses.forEach(b -> {
//				System.out.println("Bus ID : " + b.getbId());
				System.out.println("Bus Name 	: " + b.getbName());
				System.out.println("Bus type 	: " + b.getbType());
				System.out.println("Seats 		: " + b.getbSeats());
				System.out.println("Bus Route 	: " + b.getbRoute_From() + "-" + b.getbRoute_To());
//				System.out.println("Arrival Date & Time : " + b.getbArriDateTime());
//				System.out.println("Departure Date & Time : " + b.getbDeptDateTime());
				System.out.println("------------------------------");
			});

		} catch (BusException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void addBus() {

		Scanner scan = new Scanner(System.in);

		System.out.println("\nEnter new bus details : \n");
		System.out.println("Enter proper combination of bus Id & bus Name as mentioned below : ");
		System.out.println("Id - 1000 AND Name - NEETA");
		System.out.println("Id - 2000 AND Name - SRS TRAVELS");
		System.out.println("Id - 3000 AND Name - REDBUS");
		System.out.println("Id - 4000 AND Name - AIRAVAT");
		System.out.println("bId = 5000 AND bName = VOLVO");
		System.out.println("bId = 6000 AND bName = BHARAT BENZ");
		System.out.println("bId = 7000 AND bName = ASHOK LEYLAND");
		System.out.println("bId = 8000 AND bName = MAHINDRA");
		System.out.println("bId = 9000 AND bName = TATA");
		System.out.println("bId = 10000 AND bName = FORCE");

		System.out.println("\nEnter Bus Id : ");
		int bId = scan.nextInt();

		scan.nextLine();
		System.out.println("Enter Bus Name (Enter as per Id selected): ");
		String bName = scan.nextLine();

		System.out.println("Enter Bus Route-From : ");
		String bRoute_From = scan.nextLine();

		System.out.println("Enter Bus Route-To : ");
		String bRoute_To = scan.nextLine();

		System.out.println("Enter Bus Type (AC or NONAC only) : ");
		String bType = scan.nextLine();

		System.out.println("Enter Seats Available : ");
		int bSeats = scan.nextInt();

		scan.nextLine();
		System.out.println("Enter Departure Date & Time In proper format (yyyy-mm-dd hh:mm:ss): ");
		String bDeparture_DateTime = scan.nextLine();

		System.out.println("Enter Arrival Date & Time Time In proper format (yyyy-mm-dd hh:mm:ss): ");
		String bArrival_DateTime = scan.nextLine();

		System.out.println("Enter Bus Administrator ID (1 OR 2): ");
		int bAdminId = scan.nextInt();

		scan.nextLine();
		System.out.println("Enter Contact Person name associated for bus : ");
		String bConPerName = scan.nextLine();

		System.out.println("Enter Contact person contact no. : ");
		String bConPerMob = scan.nextLine();

		BusDao bDao = new BusDaoImpl();

		Bus bus = new Bus(bId, bName, bRoute_From, bRoute_To, bType, bSeats, bDeparture_DateTime, bArrival_DateTime,
				bAdminId, bConPerName, bConPerMob);

		String result = bDao.registerNewBus2(bus);

		System.out.println(result);
	}

	public static void book(String source, String destination, int tickets, String mobileNo) {
		String msg = "Booking failed.";

		BusDao bDao = new BusDaoImpl();

		try {
			Bus bus = bDao.bookTicket(source, destination, tickets, mobileNo);

			String bName = bus.getbName();
			String route = bus.getbRoute_From() + "-" + bus.getbRoute_To();
			int seats = tickets;
			String bArrival = bus.getbArriDateTime();
			String bDept = bus.getbDeptDateTime();
			String bConPerName = bus.getbConPerName();
			String bConPerMob = bus.getbConPerMob();

			int refId = AdminService.addCustomerRecord(source, destination, mobileNo, seats);

			System.out.println("Hurrey...!!! Booking successful.");
			System.out.println("find below confirmation details.");
			System.out.println("Ref ID 				  : " + refId);
			System.out.println("Bus Name 			  : " + bName);
			System.out.println("Bus Route			  : " + route);
			System.out.println("Booked Seats 		  : " + seats);
			System.out.println("Arrival Time & Date   : " + bArrival);
			System.out.println("Departure Time & Date : " + bDept);

			System.out.println("\nAlso note contact person details.");
			System.out.println("Name 	    : " + bConPerName);
			System.out.println("Contact No  : " + bConPerMob);

		} catch (BusException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int addCustomerRecord(String source, String destination, String mobile, int selectedSeats) {

		CustomerDao cDao = new CustomerDaoImpl();

		CustomerDTO customer = cDao.getCustomer(source, destination, mobile, selectedSeats);

		cDao.addCustomer(customer);

		int refId = cDao.getRefID(mobile, source, destination);

		return refId;
	}

	public static void getBookings(String mobile) {

		CustomerDao cDao = new CustomerDaoImpl();

		List<CustomerDTO> customerList = null;

		try {
			customerList = cDao.getAllBookings(mobile);

			System.out.println("\nAll bookings under mobile no : " + mobile);

			for (CustomerDTO cList : customerList) {
				System.out.println("Referance ID 	: " + cList.getRefId());
				System.out.println("Bus Name 	: " + cList.getbName());
				System.out.println("Seats Booked	: " + cList.getBookedSeats());
				System.out.println("Bus Route 	: " + cList.getbRoute_From() + "-" + cList.getbRoute_To());
				System.out.println("Mobile No 	: " + cList.getcMob());
				System.out.println("Arrival Time 	: " + cList.getbArriDateTime());
				System.out.println("Departure Time 	: " + cList.getbDeptDateTime());
				System.out.println("--------------------------------------------");
			}

		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}

	}

	public static int displayFullBuses() {

		int totalBus = 0;

		BusDao bDao = new BusDaoImpl();

		try {
			List<Bus> buses = bDao.getEmptyBuses();

			totalBus = buses.size();

			System.out.println("Displaying all full buses : ");
			buses.forEach(b -> {
				int bId = b.getbId();
				String bName = b.getbName();
				String bRoute = b.getbRoute_From() + "-" + b.getbRoute_To();
				int avalSeats = b.getbSeats();
				System.out.println("ID	: " + bId);
				System.out.println("Name	: " + bName);
				System.out.println("Route	: " + bRoute);
				System.out.println("Seats	: " + avalSeats);
				System.out.println("Status	: Full");
				System.out.println("--------------------");
			});

		} catch (BusException e) {
			System.out.println(e.getMessage());
		}

		return totalBus;
	}

	public static void removeBus() {

		int totalBuses = AdminService.displayFullBuses();

		if (totalBuses == 0) {
			return;
		}

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter bus ID : ");
		int bId = scan.nextInt();

		BusDao bDao = new BusDaoImpl();

		String message = bDao.removeBusById(bId);
		System.out.println(message);

		if (totalBuses == 0)
			return;
		else
			AdminService.removeBus();
	}
}
