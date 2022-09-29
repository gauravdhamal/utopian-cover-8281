package com.utopian.usecases;

import java.util.Scanner;

import com.utopian.bean.Administrator;
import com.utopian.dao.AdministratorDao;
import com.utopian.dao.AdministratorDaoImpl;
import com.utopian.exception.AdminException;
import com.utopian.main.BTMS;

public class LoginAdminUseCase {

	public static void loginAsAdmin() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Admin Email ");
		String email = scan.nextLine();

		System.out.println("Enter Admin Password ");
		String pass = scan.nextLine();

		AdministratorDao aDao = new AdministratorDaoImpl();

		try {
			Administrator admin = aDao.loginAdmin(email, pass);
			
			System.out.println("Congrats "+admin.getaName()+" you logged in successfully.");
			
			BTMS.selectOption();
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}

	}

}
