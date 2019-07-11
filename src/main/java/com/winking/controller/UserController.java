package com.winking.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.winking.pojo.User;
import com.winking.service.UserService;

@Controller
public class UserController {
	@Resource(name = "userService")
	private UserService userService;
	
	/**
	 * ��ת����¼ҳ��
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	/**
	 * ��ת����ҳ
	 * @return
	 */
	@RequestMapping("/toHomePage")
	public String toHomePage() {
		return "homePage";
	}
	/**
	 * ��ת��ע��ҳ��
	 * @return
	 */
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "registerUser";
	}
	/**
	 * ��ת�����ﳵ
	 * @return
	 */
	@RequestMapping("/toShoppingCart")
	public String toShoppingCart() {
		return "shoppingCart";
	}
	/**
	 * �û�ע��
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/checkUsername")
	public ModelAndView checkUsername(String userAccount,String userPassword) {
		User user = new User();
		user.setUserAccount(userAccount);
		user.setUserPassword(userPassword);
		User u = userService.findByUsername(userAccount);
		ModelAndView mav = new ModelAndView("registerUser");
		if(u != null) {
			mav.addObject("msg","�û����Ѵ���");
		}else {
			userService.registerUser(user);		
			mav.addObject("success","ע��ɹ�");
		}
		return mav;
	}
	/**
	 * ��ɫ��¼
	 */
	@RequestMapping("/loginUser")
	public ModelAndView loginUser(String username,String password,HttpServletRequest request,HttpSession session) {
		User user = new User();
		user.setUserAccount(username);
		user.setUserPassword(password);
		User u = userService.checkLoginUser(username, password);
		if(u != null) {
			session.setAttribute("USER_SESSION", username);
			ModelAndView mav = new ModelAndView("homePage");
			mav.addObject("username", username);
			return mav;
		}else {
			ModelAndView mav1 = new ModelAndView("login");
			mav1.addObject("msg","�û������������");
			return mav1;
		}
	}
	/**
	 * �û�ע��
	 */
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
