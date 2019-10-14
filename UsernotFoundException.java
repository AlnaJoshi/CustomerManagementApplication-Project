package com.cust_app.model.persistence;

public class UsernotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsernotFoundException(String msg) {
		super(msg);
	}

}
