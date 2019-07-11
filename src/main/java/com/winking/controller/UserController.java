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
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	/**
	 * 跳转到主页
	 * @return
	 */
	@RequestMapping("/toHomePage")
	public String toHomePage() {
		return "homePage";
	}
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "registerUser";
	}
	/**
	 * 跳转到购物车
	 * @return
	 */
	@RequestMapping("/toShoppingCart")
	public String toShoppingCart() {
		return "shoppingCart";
	}
	/**
	 * 用户注册
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
			mav.addObject("msg","用户名已存在");
		}else {
			userService.registerUser(user);		
			mav.addObject("success","注册成功");
		}
		return mav;
	}
	/**
	 * 角色登录
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
			mav1.addObject("msg","用户名或密码错误");
			return mav1;
		}
	}
	/**
	 * 用户注销
	 */
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
