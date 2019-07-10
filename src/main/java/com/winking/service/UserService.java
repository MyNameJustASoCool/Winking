package com.winking.service;

import com.winking.pojo.User;

public interface UserService {
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	User findByUsername(String userAccount);
	
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
	User checkLoginUser(String userAccount,String userPassword);
}
