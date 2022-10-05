package com.utopian.usecases;

import java.util.Scanner;

import com.utopian.bean.Customer;
import com.utopian.dao.CustomerDao;
import com.utopian.dao.CustomerDaoImpl;
import com.utopian.exception.CustomerException;
import com.utopian.main.Application;
import com.utopian.main.BTMSCustomer;

public class LoginCustomerUseCase {

	public static void loginCustomer() {

		Scanner scan = new Scanner(System.in);

		CustomerDao cDao = new CustomerDaoImpl();

		System.out.print("Enter your Email : ");
		String email = scan.nextLine();

		System.out.print("Enter your Pass : ");
		String pass = scan.nextLine();

		try {
			Customer customer = cDao.loginAsACustomer(email, pass);

			System.out.println("\nCongrats " + customer.getcName() + " You logged in sucessfully.");
			System.out.println(
					"Note your customer Id = " + customer.getcId() + " It is required while booking the bus.\n");

			BTMSCustomer.selectOption();

		} catch (CustomerException e) {
			System.out.println(e.getMessage());
			Application.main(null);
		}

	}

}
