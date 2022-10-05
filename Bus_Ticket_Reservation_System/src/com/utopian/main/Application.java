package com.utopian.main;

import java.util.Scanner;

import com.utopian.usecases.LoginAdminUseCase;
import com.utopian.usecases.LoginCustomerUseCase;
import com.utopian.usecases.RegisterAdminUseCase;
import com.utopian.usecases.RegisterCustomerUseCase;

public class Application {

	public static void main(String[] args) {

		System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

		System.out.println("Welcome to Bus Ticket Reservation System.");

		System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

		Scanner scan = new Scanner(System.in);

		System.out.println("\nLogin as a Admin/Customer to continue : ");
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as Customer");
		System.out.println("3. Register as a Admin.");
		System.out.println("4. Register as a customer.");
		System.out.println("99. Exit");

		System.out.print("\nEnter choice : ");
		int choice = scan.nextInt();

		switch (choice) {
		case 1:

			LoginAdminUseCase.loginAsAdmin();

			break;

		case 2:

			LoginCustomerUseCase.loginCustomer();

			break;

		case 3:
			RegisterAdminUseCase.main(null);

			Application.main(null);
			break;

		case 4:
			RegisterCustomerUseCase.main(null);

			Application.main(null);
			break;

		case 99:
			System.out.println("\nThank You...!!! Visit Again.");
			break;

		default:
			System.out.println("Select proper choice.");
			Application.main(null);
		}

	}

}
