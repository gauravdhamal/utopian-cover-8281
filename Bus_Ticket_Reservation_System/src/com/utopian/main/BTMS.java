package com.utopian.main;

import java.util.Scanner;

import com.utopian.service.AdminService;

public class BTMS {

	private static AdminService service = new AdminService();

	public static void selectOption() {

		System.out.println("\n<><><><>---- Main Menu ----<><><><>\n");

		System.out.println("0. View Admin Panel(Add/Rmove Bus, Add new admin.)");
		System.out.println("1. View all buses.");
		System.out.println("2. Book a ticket.");
		System.out.println("3. Cancel a ticket.");
		System.out.println("5. Exit");

		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter choice : ");
		int choice = scan.nextInt();
		scan.nextLine();

		switch (choice) {

		case 0:
			BTMSAdmin.selectOption();

			BTMS.selectOption();
			break;

		case 1:
			service.viewBuses();

			BTMS.selectOption();
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

			BTMS.selectOption();
			break;

		case 3:
			System.out.print("Enter your Mobile No : ");
			String mob = scan.nextLine();

			service.getBookings(mob);

			BTMS.selectOption();
			break;

		case 5:
			System.out.println("Thank You...!!! Visit Again.");
			break;

		default:
			System.out.println("Select proper choice.");
			BTMS.selectOption();
			break;
		}
	}

}
