package com.winking.dao;

import com.winking.pojo.User;

public interface UserDao {
	User findByUsername(String userAccount);
	
	void registerUser(User user);
	
}
