package com.utopian.main;

import java.util.Scanner;

import com.utopian.service.AdminService;

public class BTMSAdmin {

	public static void selectOption() {

		AdminService service = new AdminService();

		Scanner scan = new Scanner(System.in);

		System.out.println("\n<><><><>---- Admin Menu ----<><><><>\n");
		System.out.println("1. View all buses.");
		System.out.println("2. Register new bus.");
		System.out.println("3. Remove Full buses.");
		System.out.println("4. View all admins.");
		System.out.println("5. Remove admin.");
		System.out.println("99. Return to Main Menu.");

		System.out.print("\nEnter choice : ");
		int auth = scan.nextInt();
		scan.nextLine();

		switch (auth) {
		case 1:
			service.viewBuses();

			BTMSAdmin.selectOption();
			break;

		case 2:
			service.addBus();

			BTMSAdmin.selectOption();
			break;

		case 3:
			service.removeBus();

			BTMSAdmin.selectOption();
			break;

		case 4:
			service.getAdminList();

			BTMSAdmin.selectOption();
			break;

		case 5:
			service.removeAdminById();

			BTMSAdmin.selectOption();
			break;

		default:
			System.out.println("Enter correct choice.");
			BTMSAdmin.selectOption();

		case 99:
			System.out.println("\nReturning to main menu...\n");
			Application.main(null);
		}
	}

}
