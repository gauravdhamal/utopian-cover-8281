package com.utopian.dao;

import java.util.List;

import com.utopian.bean.Administrator;
import com.utopian.exception.AdminException;

public interface AdministratorDao {

	public String registerAdmin1(String name, String addr, String email, String password);

	public String registerAdmin2(Administrator admin);

	public Administrator loginAdmin(String email, String password) throws AdminException;

	public void getAllAdmin() throws AdminException;

	public int getAdminID(String email, String pass);
}
