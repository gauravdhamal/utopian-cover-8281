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
	public String registerAdmin1(int id, String name, String addr, String email, String password) {
		String message = "Not registered.";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO administrator VALUES (?,?,?,?,?)");

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, addr);
			ps.setString(4, email);
			ps.setString(5, password);

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
	public String registerAdmin2(Administrator admin) {

		String message = "Not registered.";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO administrator VALUES (?,?,?,?,?)");

			ps.setInt(1, admin.getaId());
			ps.setString(2, admin.getaName());
			ps.setString(3, admin.getaAddr());
			ps.setString(4, admin.getaEmail());
			ps.setString(5, admin.getaPass());

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
				int aId = rs.getInt("aId");
				String aName = rs.getString("aName");
				String aAddr = rs.getString("aAddr");
				String aEmail = rs.getString("aEmail");
				String aPass = rs.getString("aPass");

				admin = new Administrator(aId, aName, aAddr, aEmail, aPass);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (admin == null)
			throw new AdminException("Admin details missmatch.");

		return admin;
	}


}
