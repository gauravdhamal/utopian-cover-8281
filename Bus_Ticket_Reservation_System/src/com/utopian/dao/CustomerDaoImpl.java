package com.utopian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.utopian.bean.Bus;
import com.utopian.bean.CustomerDTO;
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

		return customer;
	}

	@Override
	public void addCustomer(CustomerDTO customer) {

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO customers VALUES (?,?,?,?,?,?,?,?,?,?)");

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

			int x = ps.executeUpdate();

			if (x > 0)
				System.out.println("Customers added to database.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
