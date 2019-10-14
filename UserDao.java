package com.cust_app.model.persistence;

import java.util.List;

public interface UserDao {
	public User findUser(String userEmail, String password);

	public void addUser(User user);

	public List<User> getAllUser();

}
