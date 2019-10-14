package com.cust_app.web.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.cust_app.model.persistence.Customer;
import com.cust_app.model.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService cust_service;
	
	@RequestMapping(value = "allCustomers", method = RequestMethod.GET)
	public String getCustomers(ModelMap map) {
		map.addAttribute("customers", cust_service.getAllCustomers());
		return "all_Customers";
	}
	
	@RequestMapping(value = "addCustomer", method = RequestMethod.GET)
	public String addCustomerGet(ModelMap map) {
		map.addAttribute("customer", new Customer());
		return "addCustomer";

	}
	
	@RequestMapping(value = "addCustomer", method = RequestMethod.POST)
	public String addCustomerPost(@Valid Customer customer,BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "addCustomer";
		}
		if (customer.getCustId() == 0)
			cust_service.addCustomer(customer);
		else
			cust_service.updateCustomer(customer);
		return "redirect:allCustomers";

	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCustomer(HttpServletRequest req,ModelMap map) {
		int custId = Integer.parseInt(req.getParameter("custId"));
		
		cust_service.removeCustomer(custId);
		return "redirect:allCustomers";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateBookGet(HttpServletRequest req, ModelMap map) {
		int custId = Integer.parseInt(req.getParameter("custId"));
		Customer customerToBeUpdated = cust_service.getCustomerById(custId);
		map.addAttribute("customer",customerToBeUpdated);
		return "addCustomer";

	}
	
	@ModelAttribute(value="productList")
	public List<String> getProductList(){
		return Arrays.asList("Fridge","Television","Mobile Phone","USB");
	}

}
