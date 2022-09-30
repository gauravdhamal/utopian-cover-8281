package com.utopian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utopian.bean.Bus;
import com.utopian.exception.BusException;
import com.utopian.service.AdminService;
import com.utopian.utility.DBUtil;

public class BusDaoImpl implements BusDao {

	@Override
	public String registerNewBus(int bId, String bName, String bRoute_From, String bRoute_To, String bType, int bSeats,
			String bDeptDateTime, String bArriDateTime, int bAdminId, String bConPerName, String bConPerMob) {
		String message = "Already Present.";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO buses VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, bId);
			ps.setString(2, bName);
			ps.setString(3, bRoute_From);
			ps.setString(4, bRoute_To);
			ps.setString(5, bType);
			ps.setInt(6, bSeats);
			ps.setString(7, bArriDateTime);
			ps.setString(8, bDeptDateTime);
			ps.setInt(9, bAdminId);
			ps.setString(10, bConPerName);
			ps.setString(11, bConPerMob);

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Bus Registered Succesfully.";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	public List<Bus> getEmptyBuses() throws BusException {

		List<Bus> buses = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM buses WHERE bSeats = 0");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bRouteFrom = rs.getString("bRoute_From");
				String bRouteTo = rs.getString("bRoute_To");
				String bType = rs.getString("bType");
				int bSeats = rs.getInt("bSeats");
				String bDeptDateTime = rs.getString("bDeptDateTime");
				String bArriDateTime = rs.getString("bArriDateTime");
				int bAdminId = rs.getInt("bAdminId");
				String bConPerName = rs.getString("bConPerName");
				String bConPerMob = rs.getString("bConPerMob");

				Bus bus = new Bus(bId, bName, bRouteFrom, bRouteTo, bType, bSeats, bDeptDateTime, bArriDateTime,
						bAdminId, bConPerName, bConPerMob);

				buses.add(bus);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (buses.size() == 0)
			throw new BusException("No any bus found with 0 seats.");

		return buses;

	}

	public String removeBusById(int bId) {
		String message = "Bus not found with ID " + bId;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("DELETE FROM buses WHERE bId = ? AND bSeats = 0");

			ps.setInt(1, bId);

			int x = ps.executeUpdate();

			if (x > 0)
				message = " Bus with ID " + bId + " removed from database.";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public String registerNewBus2(Bus bus) {
		String message = "Already Present.";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO buses VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, bus.getbId());
			ps.setString(2, bus.getbName());
			ps.setString(3, bus.getbRoute_From());
			ps.setString(4, bus.getbRoute_To());
			ps.setString(5, bus.getbType());
			ps.setInt(6, bus.getbSeats());
			ps.setString(7, bus.getbArriDateTime());
			ps.setString(8, bus.getbDeptDateTime());
			ps.setInt(9, bus.getbAdminId());
			ps.setString(10, bus.getbConPerName());
			ps.setString(11, bus.getbConPerMob());

			int x = ps.executeUpdate();

			if (x > 0)
				message = bus.getbName() + " Bus Registered Succesfully";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<Bus> getAllBusDetails() throws BusException {
		List<Bus> buses = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM buses");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bRouteFrom = rs.getString("bRoute_From");
				String bRouteTo = rs.getString("bRoute_To");
				String bType = rs.getString("bType");
				int bSeats = rs.getInt("bSeats");
				String bDeptDateTime = rs.getString("bDeptDateTime");
				String bArriDateTime = rs.getString("bArriDateTime");
				int bAdminId = rs.getInt("bAdminId");
				String bConPerName = rs.getString("bConPerName");
				String bConPerMob = rs.getString("bConPerMob");

				Bus bus = new Bus(bId, bName, bRouteFrom, bRouteTo, bType, bSeats, bDeptDateTime, bArriDateTime,
						bAdminId, bConPerName, bConPerMob);

				buses.add(bus);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (buses.size() == 0)
			throw new BusException("Buses not available.");

		return buses;
	}

	public Bus bookTicket(String source, String destination, int tickets, String mobileNo) throws BusException {

		Bus bus = new Bus();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("UPDATE buses set bSeats = bSeats - ? WHERE bRoute_From = ? AND bRoute_To = ?");

			ps.setInt(1, tickets);
			ps.setString(2, source);
			ps.setString(3, destination);

			int x = ps.executeUpdate();

			if (x > 0) {

				PreparedStatement ps2 = conn
						.prepareStatement("SELECT * FROM buses WHERE bRoute_From = ? AND bRoute_To = ?");

				ps2.setString(1, source);
				ps2.setString(2, destination);

				ResultSet rs2 = ps2.executeQuery();

				if (rs2.next()) {

					int bId = rs2.getInt("bId");
					String bName = rs2.getString("bName");
					String bRouteFrom = rs2.getString("bRoute_From");
					String bRouteTo = rs2.getString("bRoute_To");
					String bType = rs2.getString("bType");
					int bSeats = rs2.getInt("bSeats");
					String bDeptDateTime = rs2.getString("bDeptDateTime");
					String bArriDateTime = rs2.getString("bArriDateTime");
					int bAdminId = rs2.getInt("bAdminId");
					String bConPerName = rs2.getString("bConPerName");
					String bConPerMob = rs2.getString("bConPerMob");

					bus = new Bus(bId, bName, bRouteFrom, bRouteTo, bType, bSeats, bDeptDateTime, bArriDateTime,
							bAdminId, bConPerName, bConPerMob);

				}
			}

		} catch (SQLException e) {
			int avalTickets = this.noOfTicketsAval(source, destination);
			if (avalTickets == 0)
				throw new BusException("Bus is Full. Try for another one");
			else
				throw new BusException("Insufficient tickets available.\nOnly " + avalTickets + " tickets avaliable.");
		}

		if (bus == null)
			throw new BusException("Enter proper Source and destination.");

		return bus;
	}

	@Override
	public int noOfTicketsAval(String source, String destination) {
		int avalTicket = 0;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("SELECT bSeats FROM buses WHERE bRoute_From = ? AND bRoute_To = ?");

			ps.setString(1, source);
			ps.setString(2, destination);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				avalTicket = rs.getInt("bSeats");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return avalTicket;
	}

	@Override
	public Bus getBus(String source, String destination) {
		Bus bus = new Bus();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM buses WHERE bRoute_From = ? AND bRoute_To = ?");

			ps.setString(1, source);
			ps.setString(2, destination);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bRouteFrom = rs.getString("bRoute_From");
				String bRouteTo = rs.getString("bRoute_To");
				String bType = rs.getString("bType");
				int bSeats = rs.getInt("bSeats");
				String bDeptDateTime = rs.getString("bDeptDateTime");
				String bArriDateTime = rs.getString("bArriDateTime");
				int bAdminId = rs.getInt("bAdminId");
				String bConPerName = rs.getString("bConPerName");
				String bConPerMob = rs.getString("bConPerMob");

				bus = new Bus(bId, bName, bRouteFrom, bRouteTo, bType, bSeats, bDeptDateTime, bArriDateTime, bAdminId,
						bConPerName, bConPerMob);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return bus;
	}

}
