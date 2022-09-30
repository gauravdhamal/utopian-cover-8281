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
		System.out.println("5. Return to Main Menu.");

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

		case 5:
			System.out.println("Returning to main menu.");
			break;

		default:
			break;
		}
	}

}
