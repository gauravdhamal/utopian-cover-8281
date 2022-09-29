package com.utopian.dao;

import com.utopian.bean.Administrator;
import com.utopian.exception.AdminException;

public interface AdministratorDao {
	
	public String registerAdmin1(int id, String name, String addr, String email, String password);
	
	public String registerAdmin2(Administrator admin);
	
	public Administrator loginAdmin(String email, String password) throws AdminException;
	
}
