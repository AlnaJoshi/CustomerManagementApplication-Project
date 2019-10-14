package com.cust_app.model.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="userTable_custApp1")

public class User {
	@Id @GeneratedValue
	private int id;
	private String userName;
	
	@Column(unique=true)
	private String userEmail;
	private String password;
	private String profile;
	private boolean isActive;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public User() {}
	public User(String userName, String userEmail, String password, String profile, boolean isActive) {
		
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.profile = profile;
		this.isActive = isActive;
	}
	

}
