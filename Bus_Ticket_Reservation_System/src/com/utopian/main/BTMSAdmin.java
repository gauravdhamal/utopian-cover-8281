package com.utopian.main;

import java.util.Scanner;

import com.utopian.service.AdminService;

public class BTMSAdmin {

	private static AdminService service = new AdminService();

	public static void selectOption() {

		Scanner scan = new Scanner(System.in);

		System.out.println("\n<><><><>---- Admin Menu ----<><><><>\n");
		System.out.println("1. Register new bus.");
		System.out.println("2. Remove Full buses.");
		System.out.println("3. Register new Admin.");
		System.out.println("4. View all admins.");
		System.out.println("5. Remove admin.");
		System.out.println("99. Return to Main Menu.");

		System.out.print("\nEnter choice : ");
		int auth = scan.nextInt();
		scan.nextLine();

		switch (auth) {
		case 1:
			service.addBus();

			BTMSAdmin.selectOption();
			break;

		case 2:
			service.removeBus();

			BTMSAdmin.selectOption();
			break;

		case 3:
			service.registerNewAdmin();

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

		case 99:
			System.out.println("\nReturning to main menu.");
			break;

		default:
			break;
		}
	}

}
