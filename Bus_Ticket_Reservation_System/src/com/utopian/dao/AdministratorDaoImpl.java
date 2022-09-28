package com.utopian.dao;

import com.utopian.bean.Administrator;
import com.utopian.utility.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class AdministratorDaoImpl implements AdministratorDao {

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
}
