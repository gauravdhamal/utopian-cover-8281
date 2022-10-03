package com.utopian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

			if (x > 0) {
				int adminId = this.getAdminID(email, password);

				message = name + " registered as Admin succesfully.\nNote your Admin ID : " + adminId
						+ " required at the time registering new bus.";
			}

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
	public int getAdminID(String email, String pass) {
		int aId = 0;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("SELECT aId FROM administrator WHERE aEmail = ? AND aPass = ?");

			ps.setString(1, email);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				aId = rs.getInt("aId");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return aId;
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

	@Override
	public String removeAdminById(int aId) throws AdminException {

		String message = "Admin not found with ID : " + aId;

		String adminName = getAdminNameById(aId);

		if (adminName.equals("null"))
			throw new AdminException("Admin not found with ID : " + aId);

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("DELETE FROM administrator WHERE aId = ?");

			ps.setInt(1, aId);

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "Admin " + adminName + " with ID : " + aId + " Removed from database.";
			}

		} catch (SQLException e) {
			message = e.getMessage();
			e.printStackTrace();
		}

		return message;
	}

	@Override
	public String getAdminNameById(int aId) {
		String message = "null";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT aName FROM administrator WHERE aId = ?");

			ps.setInt(1, aId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				message = rs.getString("aName");
			}

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}
}
