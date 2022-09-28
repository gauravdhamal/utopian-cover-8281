package com.utopian.dao;

import com.utopian.bean.Administrator;

public interface AdministratorDao {
	
	public String registerAdmin1(int id, String name, String addr, String email, String password);
	
	public String registerAdmin2(Administrator admin);
	
}
