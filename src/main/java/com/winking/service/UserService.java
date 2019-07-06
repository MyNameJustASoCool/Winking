package com.winking.service;

import com.winking.pojo.User;

public interface UserService {
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	User findByUsername(String username);
	
	/**
	 * ע���û�
	 * @param user
	 */
	void registerUser(User user);
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return
	 */
	User checkLoginUser(String username,String password);
}
