package com.cust_app.model.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory factory;

	public Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public User findUser(String userEmail, String password) {
		@SuppressWarnings("unchecked")
		List<User> users = getSession()
				.createQuery("select u from User u where u.userEmail=:userEmail and  u.password=:password")
				.setString("userEmail", userEmail).setString("password", password).list();
		if (users.size() > 0)
			return users.get(0);
		else {
			throw new UsernotFoundException("user with email " + userEmail + " not found");
		}
	}

	@Override
	public void addUser(User user) {
		getSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {

		return getSession().createQuery("from User").list();
	}

}
