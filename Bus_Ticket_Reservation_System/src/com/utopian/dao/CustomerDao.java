package com.utopian.dao;

import java.util.List;

import com.utopian.bean.Customer;
import com.utopian.bean.CustomerDTO;
import com.utopian.exception.CustomerException;

public interface CustomerDao {

	public CustomerDTO getCustomer(String source, String destination, String mobile, int selectedSeats);

	public void addCustomer(CustomerDTO customer);

	public List<CustomerDTO> getAllBookings(String mobile) throws CustomerException;

	public int getRefID(String mob, String source, String destiny);

	public String registerCustomer(Customer customer);

	public Customer loginAsACustomer(String cEmail, String cPass) throws CustomerException;
}
