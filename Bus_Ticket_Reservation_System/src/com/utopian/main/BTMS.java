package com.utopian.main;

import java.util.Scanner;

import com.utopian.service.AdminService;

public class BTMS {

	private static AdminService service = new AdminService();

	public static void selectOption() {

		System.out.println("\nSelect an option to continue...");

		System.out.println("\n1. View all buses.\n2. Book a ticket.\n3. Cancel a ticket.\n10. Exit.");

		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();

		switch (choice) {

		case 1:
			service.viewBuses();

			BTMS.selectOption();
			break;

		case 2:
			scan.nextLine();
			System.out.print("Enter source location : ");
			String source = scan.nextLine();

			System.out.print("Enter destination : ");
			String destination = scan.nextLine();

			System.out.print("Enter no of tickets : ");
			int tickets = scan.nextInt();

			scan.nextLine();
			System.out.print("Enter your mobile no : ");
			String mobileNo = scan.nextLine();

			String result = service.book(source, destination, tickets);
			System.out.println(result);

			if (result.equals("Ticket booked sucessfully.")) {
				service.addCustomerRecord(source, destination, mobileNo, tickets);
			}

			BTMS.selectOption();
			break;

		case 3:

			BTMS.selectOption();
			break;

		case 10:
			System.out.println("Thank You...!!!");
			break;

		default:
			BTMS.selectOption();
			break;
		}
	}

}
