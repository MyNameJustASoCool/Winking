package com.winking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winking.dao.UserDao;
import com.winking.pojo.User;
import com.winking.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public User findByUsername(String userAccount) {
		
		return userDao.findByUsername(userAccount);
	}

	public void registerUser(User user) {
		userDao.registerUser(user);
	}

	@Override
	public User checkLoginUser(String userAccount, String userPassword) {
		User user = userDao.findByUsername(userAccount);
		if(user != null && user.getUserPassword().equals(userPassword)) {
			return user;
		}
		return null;
	}

}
