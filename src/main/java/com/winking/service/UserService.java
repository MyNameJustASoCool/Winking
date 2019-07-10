package com.winking.service;

import com.winking.pojo.User;

public interface UserService {
	/**
	 * 检测用户
	 * @param user
	 * @return
	 */
	User findByUsername(String userAccount);
	
	/**
	 * 注册用户
	 * @param user
	 */
	void registerUser(User user);
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	User checkLoginUser(String userAccount,String userPassword);
}
