package com.utopian.main;

import java.util.Scanner;

import com.utopian.usecases.LoginCustomerUseCase;

public class BTMSCustomer {

	static Scanner scan = new Scanner(System.in);

	public static void selectOption() {

		System.out.println("1. To register as a customer.");
		System.out.println("99. Return to main menu.");

		System.out.print("Enter choice : ");
		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			LoginCustomerUseCase.loginCustomer();
			BTMSCustomer.selectOption();
			break;

		case 99:
			System.out.println("Returning to main menu...");
			BTMS.selectOption();
			break;

		default:
			System.out.println("Enter correct choice.");
			BTMSCustomer.selectOption();
		}

	}

}
