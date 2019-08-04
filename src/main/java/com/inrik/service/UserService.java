package com.inrik.service;

import java.util.List;

import com.inrik.auth.model.User;


public interface UserService {
	public List<User> getUserInfos();

	public User getUserInfo(String username);  

	public void delete(int UserId);
}

