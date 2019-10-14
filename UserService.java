package com.cust_app.model.service;

import java.util.List;

import com.cust_app.model.persistence.User;

public interface UserService {
	public User findUser(String userEmail, String password);

	public void addUser(User user);

	public List<User> getAllUser();
}
