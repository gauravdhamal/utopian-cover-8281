package com.utopian.usecases;

import java.util.Scanner;

import com.utopian.bean.Customer;
import com.utopian.dao.CustomerDao;
import com.utopian.dao.CustomerDaoImpl;

public class LoginCustomerUseCase {

	public static void loginCustomer() {

		CustomerDao cDao = new CustomerDaoImpl();

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your name : ");
		String name = scan.nextLine();

		System.out.print("Enter your Address : ");
		String addr = scan.nextLine();

		System.out.print("Enter your Mobile no : ");
		String mob = scan.nextLine();

		System.out.print("Enter your email ID : ");
		String email = scan.nextLine();

		System.out.print("Enter your password : ");
		String pass = scan.nextLine();

		Customer customer = new Customer(0, name, addr, mob, email, pass);

		String message = cDao.registerCustomer(customer);
		System.out.println(message);

	}
}
