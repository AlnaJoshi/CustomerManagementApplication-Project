package com.cust_app.model.service;

import java.util.List;

import com.cust_app.model.persistence.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int custId);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(int custId);
}
