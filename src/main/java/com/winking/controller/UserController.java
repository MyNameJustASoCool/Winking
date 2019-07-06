package com.winking.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.winking.pojo.User;
import com.winking.service.UserService;

@Controller
@RequestMapping("/")
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
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "registerUser";
	}
	/**
	 * 用户注册
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/checkUsername")
	public ModelAndView checkUsername(String username,String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User u = userService.findByUsername(username);
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
	public ModelAndView loginUser(String username,String password,HttpServletRequest request,String r1) {
		String radio = r1;
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User u = userService.checkLoginUser(username, password);
		if(radio.equals("管理员")) {
			if(u != null && u.getRoal() == 1) {
				ModelAndView mav = new ModelAndView("adminPage");
				mav.addObject("username",username);
				return mav;
			}else {
				ModelAndView mav1 = new ModelAndView("login");
				mav1.addObject("msg","用户名或密码错误");
				return mav1;
			}
		}else if(radio.equals("用户")){
			if(u != null && u.getRoal() == 0) {
				ModelAndView mav = new ModelAndView("homePage");
				mav.addObject("username",username);
				return mav;
			}else {
				ModelAndView mav1 = new ModelAndView("login");
				mav1.addObject("msg","用户名或密码错误");
				return mav1;
			}	
		}else {
			ModelAndView mav1 = new ModelAndView("login");
			mav1.addObject("msg","请选择角色登录");
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
