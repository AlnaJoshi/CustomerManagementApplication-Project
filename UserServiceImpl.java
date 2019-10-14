package com.cust_app.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust_app.model.persistence.User;
import com.cust_app.model.persistence.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findUser(String userEmail, String password) {

		return userDao.findUser(userEmail, password);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);

	}

	@Override
	public List<User> getAllUser() {

		return userDao.getAllUser();
	}

}
