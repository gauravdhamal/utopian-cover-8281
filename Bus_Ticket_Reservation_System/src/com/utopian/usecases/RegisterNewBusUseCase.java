package com.utopian.usecases;

import java.util.Scanner;

public class RegisterNewBusUseCase {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter new bus details : \n");
		System.out.println("Enter Bus Id : ");
		System.out.println("Enter proper combination of bus Id & bus Name as mentioned below : ");
		System.out.println("Id - 1 AND Name - Neeta");
		System.out.println("Id - 2 AND Name - Red");
		System.out.println("Id - 3 AND Name - SRS");
		System.out.println("Id - 4 AND Name - Airavat");
		int bId = scan.nextInt();
		
		System.out.println("Enter Bus Name : ");
		System.out.println("Enter Bus Route : ");
		System.out.println("Enter Bus Type : ");
		System.out.println("Enter Seats Available : ");
		System.out.println("Enter Departure Date & Time : ");
		System.out.println("Enter Arrival Date & Time : ");
		System.out.println("Enter Bus Administrator ID : ");
		
	}
	
}
