package com.utopian.dao;

import com.utopian.bean.CustomerDTO;

public interface CustomerDao {

	public CustomerDTO getCustomer(String source, String destination, String mobile, int selectedSeats);

	public void addCustomer(CustomerDTO customer);
}
