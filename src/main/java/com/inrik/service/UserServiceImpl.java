package com.inrik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inrik.dao.UserDao;
import com.inrik.auth.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUserInfos() {
		return userDao.findAll();
	}

	@Override
	public User getUserInfo(String username) {
		return userDao.getUser(username);
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
	}


	public UserDao getUserDao(){
		return userDao;
	}

	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

}
