package com.utopian.usecases;

import java.util.Scanner;

import com.utopian.bean.Administrator;
import com.utopian.dao.AdministratorDao;
import com.utopian.dao.AdministratorDaoImpl;
import com.utopian.exception.AdminException;
import com.utopian.main.Application;
import com.utopian.main.BTMSAdmin;

public class LoginAdminUseCase {

	public static void loginAsAdmin() {

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter Admin Email	: ");
		String email = scan.nextLine();

		System.out.print("Enter Admin Password	: ");
		String pass = scan.nextLine();

		AdministratorDao aDao = new AdministratorDaoImpl();

		try {
			Administrator admin = aDao.loginAdmin(email, pass);
			int adminId = aDao.getAdminID(email, pass);

			System.out.println("\nCongrats " + admin.getaName() + " you logged in successfully.");
			System.out.println("Note your admin ID : " + adminId + " required at the time registering new bus.");

			BTMSAdmin.selectOption();

		} catch (AdminException e) {
			System.out.println(e.getMessage() + "\nEnter Details again\n");
			Application.main(null);
		}

	}

}
