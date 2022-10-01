package com.utopian.usecases;

import java.util.Scanner;

import com.utopian.bean.Administrator;
import com.utopian.dao.AdministratorDao;
import com.utopian.dao.AdministratorDaoImpl;

public class RegisterAdminUseCase2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter admin details : ");

		System.out.println("Enter admin name : ");
		String name = scan.nextLine();

		System.out.println("Enter admin address : ");
		String addr = scan.nextLine();

		System.out.println("Enter admin email : ");
		String email = scan.nextLine();

		System.out.println("Enter admin password : ");
		String pass = scan.nextLine();

		AdministratorDao adao = new AdministratorDaoImpl();

		Administrator admin = new Administrator(name, addr, email, pass);

		String result = adao.registerAdmin2(admin);

		System.out.println(result);

	}

}
