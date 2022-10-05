package com.utopian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utopian.bean.Bus;
import com.utopian.bean.Customer;
import com.utopian.bean.CustomerDTO;
import com.utopian.exception.CustomerException;
import com.utopian.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public CustomerDTO getCustomer(String source, String destination, String mobile, int selectedSeats) {
		CustomerDTO customer = new CustomerDTO();

		BusDao bDao = new BusDaoImpl();

		Bus bus = bDao.getBus(source, destination);

		customer.setcMob(mobile);
		customer.setbId(bus.getbId());
		customer.setbName(bus.getbName());
		customer.setbRoute_From(bus.getbRoute_From());
		customer.setbRoute_To(bus.getbRoute_To());
		customer.setbType(bus.getbType());
		customer.setBookedSeats(selectedSeats);
		customer.setbDeptDateTime(bus.getbDeptDateTime());
		customer.setbArriDateTime(bus.getbArriDateTime());
		customer.setbAdminId(bus.getbAdminId());
		customer.setbConPerName(bus.getbConPerName());
		customer.setbConPerMob(bus.getbConPerMob());

		return customer;
	}

	@Override
	public void addCustomer(CustomerDTO customer) {

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO customers (mob,bId,bName,bRoute_From,bRoute_To,bType,bookedSeats,bDeptDateTime,bArriDateTime,bAdminId,bConPerName,bConPerMob) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, customer.getcMob());
			ps.setInt(2, customer.getbId());
			ps.setString(3, customer.getbName());
			ps.setString(4, customer.getbRoute_From());
			ps.setString(5, customer.getbRoute_To());
			ps.setString(6, customer.getbType());
			ps.setInt(7, customer.getBookedSeats());
			ps.setString(8, customer.getbDeptDateTime());
			ps.setString(9, customer.getbArriDateTime());
			ps.setInt(10, customer.getbAdminId());
			ps.setString(11, customer.getbConPerName());
			ps.setString(12, customer.getbConPerMob());

			int x = ps.executeUpdate();

			if (x > 0)
				System.out.println("Customers added to database.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<CustomerDTO> getAllBookings(String mobile) throws CustomerException {
		List<CustomerDTO> cDto = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE mob = ?");

			ps.setString(1, mobile);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String mob = rs.getString("mob");
				int refId = rs.getInt("refId");
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bRouteFrom = rs.getString("bRoute_From");
				String bRouteTo = rs.getString("bRoute_To");
				String bType = rs.getString("bType");
				int bookedSeats = rs.getInt("bookedSeats");
				String bDeptDateTime = rs.getString("bDeptDateTime");
				String bArriDateTime = rs.getString("bArriDateTime");
				int bAdminId = rs.getInt("bAdminId");
				String bConPerName = rs.getString("bConPerName");
				String bConPerMob = rs.getString("bConPerMob");

				CustomerDTO customer = new CustomerDTO(mob, refId, bId, bName, bRouteFrom, bRouteTo, bType, bookedSeats,
						bDeptDateTime, bArriDateTime, bAdminId, bConPerName, bConPerMob);

				cDto.add(customer);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (cDto.size() == 0)
			throw new CustomerException("No bookings found under mobile no : " + mobile);

		return cDto;
	}

	public int getRefID(String mob, String source, String destiny) {
		int refId = 0;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"SELECT refId FROM customers WHERE mob = ? AND bRoute_From = ? AND bRoute_To = ?");

			ps.setString(1, mob);
			ps.setString(2, source);
			ps.setString(3, destiny);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				refId = rs.getInt("refId");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return refId;
	}

	@Override
	public String registerCustomer(Customer customer) {
		String message = "";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO customer_data (cName,cAddr,cMob,cEmail,cPass) VALUES (?,?,?,?,?)");

			ps.setString(1, customer.getcName());
			ps.setString(2, customer.getcAddr());
			ps.setString(3, customer.getcMob());
			ps.setString(4, customer.getcEmail());
			ps.setString(5, customer.getcPass());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Congrats " + customer.getcName() + " Registration successful...!!!";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public Customer loginAsACustomer(String cEmail, String cPass) throws CustomerException {

		Customer customer = null;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer_data WHERE cEmail = ? AND cPass = ?");

			ps.setString(1, cEmail);
			ps.setString(2, cPass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int cId = rs.getInt("cId");
				String name = rs.getString("cName");
				String addr = rs.getString("cAddr");
				String mob = rs.getString("cMob");
				String email = rs.getString("cEmail");
				String pass = rs.getString("cPass");

				customer = new Customer(cId, name, addr, mob, cEmail, cPass);
			}

		} catch (SQLException e) {
			throw new CustomerException("pass not correct.");
		}

		if (customer == null)
			throw new CustomerException("\nemail or pass not correct. Try again...\n");

		return customer;

	}
}
