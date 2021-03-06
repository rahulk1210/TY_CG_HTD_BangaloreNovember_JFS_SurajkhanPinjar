package com.capgemini.forestrymanagementspringrest.dao;

import java.util.ArrayList;

import com.capgemini.forestrymanagementspringrest.dto.Customer;

public interface CustomerDao {
	public boolean addCustomer(Customer customer);

	public boolean deleteCustomer(int customerId);

	public Customer getCustomer(int customerId);

	public ArrayList<Customer> getAllCust();

	public boolean modifyCustomer(Customer customer);

	

}
