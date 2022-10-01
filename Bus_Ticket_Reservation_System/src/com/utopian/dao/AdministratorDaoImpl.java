package com.utopian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utopian.bean.Administrator;
import com.utopian.exception.AdminException;
import com.utopian.utility.DBUtil;

public class AdministratorDaoImpl implements AdministratorDao {

	@Override
	public String registerAdmin1(String name, String addr, String email, String password) {
		String message = "Not registered.";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO administrator(aName,aAddr,aEmail,aPass) VALUES (?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setString(3, email);
			ps.setString(4, password);

			int x = ps.executeUpdate();

			if (x > 0)
				message = name + " registered as Admin succesfully.";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public String registerAdmin2(Administrator admin) {

		String message = "Not registered.";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO administrator (aName,aAddr,aEmail,aPass) VALUES (?,?,?,?)");

			ps.setString(1, admin.getaName());
			ps.setString(2, admin.getaAddr());
			ps.setString(3, admin.getaEmail());
			ps.setString(4, admin.getaPass());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Admin registered succesfully.";
			else
				message = "Admin already present.";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public Administrator loginAdmin(String email, String password) throws AdminException {

		Administrator admin = null;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM administrator WHERE aEmail = ? AND aPass = ?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String aName = rs.getString("aName");
				String aAddr = rs.getString("aAddr");
				String aEmail = rs.getString("aEmail");
				String aPass = rs.getString("aPass");

				admin = new Administrator(aName, aAddr, aEmail, aPass);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (admin == null)
			throw new AdminException("Admin details missmatch.");

		return admin;
	}

	public void getAllAdmin() throws AdminException {

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM administrator");

			ResultSet rs = ps.executeQuery();

			System.out.println("\nDisplaying all admin details.");

			while (rs.next()) {
				System.out.println("Admin ID : " + rs.getInt("aId"));
				System.out.println("Admin Name : " + rs.getString("aName"));
				System.out.println("Admin address : " + rs.getString("aAddr"));
				System.out.println("Admin email : " + rs.getString("aEmail"));
				System.out.println("-----------------------------");
			}

		} catch (SQLException e) {
			throw new AdminException("No any admin registered. Register first.");
		}
	}
}
