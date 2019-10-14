package com.cust_app.web.controller;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserFormBean {
	@NotEmpty(message="Email should not be blank")
	@Email(message="Please, enter a valid email")
	private String userEmail;
	
	@NotEmpty(message="password can  not be null")
	private String password;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
