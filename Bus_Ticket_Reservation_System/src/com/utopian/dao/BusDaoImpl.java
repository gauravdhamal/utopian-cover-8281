package com.utopian.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.utopian.utility.DBUtil;
import com.utopian.bean.Bus;
import java.sql.Connection;

public class BusDaoImpl implements BusDao {

	public String registerNewBus(int bId, String bName, String bRoute, String bType, int bSeats, String bDeptDateTime,
			String bArriDateTime, int bAdminId) {
		String message = "Already Present.";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO buses VALUES (?,?,?,?,?,?,?,?)");

			ps.setInt(1, bId);
			ps.setString(2, bName);
			ps.setString(3, bRoute);
			ps.setString(4, bType);
			ps.setInt(5, bSeats);
			ps.setString(6, bArriDateTime);
			ps.setString(7, bDeptDateTime);
			ps.setInt(8, bAdminId);

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Bus Registered Succesfully";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return message;
	}

	public String registerNewBus2(Bus bus) {
		String message = "Already Present.";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO buses VALUES (?,?,?,?,?,?,?,?)");

			ps.setInt(1, bus.getbId());
			ps.setString(2, bus.getbName());
			ps.setString(3, bus.getbRoute());
			ps.setString(4, bus.getbType());
			ps.setInt(5, bus.getbSeats());
			ps.setString(6, bus.getbArriDateTime());
			ps.setString(7, bus.getbDeptDateTime());
			ps.setInt(8, bus.getbAdminId());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Bus Registered Succesfully";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return message;
	}

}
