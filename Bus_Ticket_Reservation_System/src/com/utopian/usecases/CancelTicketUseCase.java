package com.utopian.usecases;

import java.util.Scanner;

import com.utopian.dao.BusDao;
import com.utopian.dao.BusDaoImpl;

public class CancelTicketUseCase {

	private static BusDao bDao = new BusDaoImpl();

	public static void selectChoice() {

		Scanner scan = new Scanner(System.in);

		System.out.println("\n<><><><>---- Customer Menu ----<><><><>\n");
		System.out.println("1. Press 1 to cancel ticket.");
		System.out.println("2. Press 2 to return to main menu.");

		System.out.print("\nEnter choice : ");
		int choice = scan.nextInt();

		switch (choice) {
		case 1:

			System.out.print("\nEnter referance ID to cancel ticket : ");
			int refId = scan.nextInt();

			int bId = bDao.getBusId(refId);
			int freeSeats = bDao.getReleasedSeats(refId);

			String result = bDao.cancelTicket(refId);

			System.out.println(result);

			if (result.contains("Ticket with refID : ")) {
				bDao.updateBusSeats(bId, freeSeats);
			}

			System.out.println("\nWant to cancel more tickets.");

			System.out.print("Enter Y/N ? : ");
			String proceed = scan.next();

			if (proceed.equals("y") || proceed.equals("Y"))
				CancelTicketUseCase.selectChoice();
			else {
				System.out.println("Returning to main menu...");
				break;
			}
			break;

		case 2:
			System.out.println("Returning to main menu...");
			break;

		default:
			System.out.println("Select proper choice.");
			CancelTicketUseCase.selectChoice();
			break;
		}

	}

}
