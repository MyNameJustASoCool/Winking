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
	 * ��ת����¼ҳ��
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
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
	 * �û�ע��
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
	public ModelAndView loginUser(String username,String password,HttpServletRequest request,String r1) {
		String radio = r1;
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User u = userService.checkLoginUser(username, password);
		if(radio.equals("����Ա")) {
			if(u != null && u.getRoal() == 1) {
				ModelAndView mav = new ModelAndView("adminPage");
				mav.addObject("username",username);
				return mav;
			}else {
				ModelAndView mav1 = new ModelAndView("login");
				mav1.addObject("msg","�û������������");
				return mav1;
			}
		}else if(radio.equals("�û�")){
			if(u != null && u.getRoal() == 0) {
				ModelAndView mav = new ModelAndView("homePage");
				mav.addObject("username",username);
				return mav;
			}else {
				ModelAndView mav1 = new ModelAndView("login");
				mav1.addObject("msg","�û������������");
				return mav1;
			}	
		}else {
			ModelAndView mav1 = new ModelAndView("login");
			mav1.addObject("msg","��ѡ���ɫ��¼");
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
