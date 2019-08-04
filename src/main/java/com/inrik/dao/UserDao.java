package com.inrik.dao;

import java.util.List;

import com.inrik.auth.model.User;


public interface UserDao {
	public List<User> findAll();
	public User getUser(String emailAddress);
	public void setUser(User user);
	public void delete(int usererId);
}

