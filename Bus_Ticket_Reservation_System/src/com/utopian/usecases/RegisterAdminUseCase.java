package com.utopian.usecases;

import java.util.Scanner;
import com.utopian.dao.AdministratorDao;
import com.utopian.dao.AdministratorDaoImpl;

public class RegisterAdminUseCase {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter admin details : ");

		System.out.println("Enter admin ID : ");
		int id = scan.nextInt();

		scan.nextLine();
		System.out.println("Enter admin name : ");
		String name = scan.nextLine();

		System.out.println("Enter admin address : ");
		String addr = scan.nextLine();

		System.out.println("Enter admin email : ");
		String email = scan.nextLine();

		System.out.println("Enter admin password : ");
		String pass = scan.nextLine();

		AdministratorDao adao = new AdministratorDaoImpl();

		String result = adao.registerAdmin1(id, name, addr, email, pass);

		System.out.println(result);

	}

}
