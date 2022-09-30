package com.utopian.main;

import com.utopian.usecases.LoginAdminUseCase;

public class Application {
	
	public static void main(String[] args) {
		
		System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
		
		System.out.println("Welcome to Bus Ticket Reservation System.");
		
		System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
		
		System.out.println("\nLogin as Admin first.\n");
		
		LoginAdminUseCase.loginAsAdmin();
		
	}
	
}
