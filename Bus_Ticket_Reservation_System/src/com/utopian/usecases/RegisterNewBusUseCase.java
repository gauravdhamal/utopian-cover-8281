package com.utopian.usecases;

import com.utopian.bean.Bus;
import com.utopian.dao.*;
import java.util.Scanner;

public class RegisterNewBusUseCase {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter new bus details : \n");
		System.out.println("Enter proper combination of bus Id & bus Name as mentioned below : ");
		System.out.println("Id - 1000 AND Name - Neeta");
		System.out.println("Id - 2000 AND Name - SRS");
		System.out.println("Id - 3000 AND Name - Red");
		System.out.println("Id - 4000 AND Name - Airavat");
		System.out.println("\nEnter Bus Id : ");
		int bId = scan.nextInt();
		
		scan.nextLine();
		System.out.println("Enter Bus Name (Enter as per Id selected): ");
		String bName  = scan.nextLine();
		
		System.out.println("Enter Bus Route-From : ");
		String bRoute_From  = scan.nextLine();
		
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
		
		BusDao bDao = new BusDaoImpl();
		
		Bus bus = new Bus(bId, bName, bRoute_From, bRoute_To, bType, bSeats, bDeparture_DateTime, bArrival_DateTime, bAdminId);
		
		String result = bDao.registerNewBus2(bus);
		
		System.out.println(result);
		
	}
	
}
