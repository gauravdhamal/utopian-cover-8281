package com.utopian.usecases;

import java.util.Scanner;
import com.utopian.dao.AdministratorDao;
import com.utopian.dao.AdministratorDaoImpl;

public class RegisterAdminUseCase {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("\nEnter admin details.");

		System.out.print("Enter admin name : ");
		String name = scan.nextLine();

		System.out.print("Enter admin address : ");
		String addr = scan.nextLine();

		System.out.print("Enter admin email : ");
		String email = scan.nextLine();

		System.out.print("Enter admin password : ");
		String pass = scan.nextLine();

		AdministratorDao adao = new AdministratorDaoImpl();

		String result = adao.registerAdmin1(name, addr, email, pass);

		System.out.println(result);

	}

}
