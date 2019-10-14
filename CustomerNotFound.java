package com.cust_app.model.service;

public class CustomerNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFound(String message) {
		super(message);
	}

}
