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
	
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

	public void registerUser(User user) {
		userDao.registerUser(user);
	}

	@Override
	public User checkLoginUser(String username, String password) {
		User user = userDao.findByUsername(username);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

}
