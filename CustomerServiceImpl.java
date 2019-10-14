package com.cust_app.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust_app.model.persistence.Customer;
import com.cust_app.model.persistence.CustomerDAO;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO cust;

	@Override
	public List<Customer> getAllCustomers() {

		return cust.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(int custId) {
		Customer customer=cust.getCustomerById(custId);
		if(customer==null)
			throw new CustomerNotFound("Customer with " + custId + " is not found!");
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		return cust.addCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		return cust.updateCustomer(customer);
	}

	@Override
	public Customer removeCustomer(int custId) {
		
		return cust.removeCustomer(custId);
	}

}
