package com.utopian.main;

import java.util.Scanner;

import com.utopian.usecases.LoginAdminUseCase;

public class Application {

	public static void main(String[] args) {

		System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

		System.out.println("Welcome to Bus Ticket Reservation System.");

		System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter any key to continue : ");
		String anyKey = scan.next();

		System.out.println("\nLogin as Admin first.\n");

		LoginAdminUseCase.loginAsAdmin();

	}

}
