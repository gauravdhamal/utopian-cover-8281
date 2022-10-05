package com.utopian.main;

import java.util.Scanner;

import com.utopian.service.AdminService;

public class BTMSCustomer {

	static Scanner scan = new Scanner(System.in);

	private static AdminService service = new AdminService();

	public static void selectOption() {

		System.out.println("\n<><><><>---- Customer Menu ----<><><><>\n");
		System.out.println("1. View all buses.");
		System.out.println("2. Book a ticket.");
		System.out.println("3. Cancel a ticket.");
		System.out.println("99. Return to main menu.");

		System.out.print("\nEnter choice : ");
		int choice = scan.nextInt();
		scan.nextLine();

		switch (choice) {

		case 1:
			service.viewBuses();

			BTMSCustomer.selectOption();
			break;

		case 2:

			System.out.print("Enter source location : ");
			String source = scan.nextLine();

			System.out.print("Enter destination : ");
			String destination = scan.nextLine();

			System.out.print("Enter no of tickets : ");
			int tickets = scan.nextInt();

			scan.nextLine();
			System.out.print("Enter your mobile no : ");
			String mobileNo = scan.nextLine();

			service.book(source, destination, tickets, mobileNo);

			BTMSCustomer.selectOption();
			break;

		case 3:
			System.out.print("Enter your Mobile No : ");
			String mob = scan.nextLine();

			service.getBookings(mob);

			BTMSCustomer.selectOption();
			break;

		default:
			System.out.println("Enter correct choice.");
			BTMSCustomer.selectOption();

		case 99:
			System.out.println("\nReturning to main menu...\n");
			Application.main(null);
		}

	}

}
