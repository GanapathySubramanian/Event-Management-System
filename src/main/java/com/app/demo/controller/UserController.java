package com.app.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.demo.model.User;
import com.app.demo.services.UserServices;

@Controller
public class UserController {
	
	@Autowired
	private UserServices service;
	
	
	@RequestMapping(value="/registerForm",method= RequestMethod.POST)
	public String UserRegister(@ModelAttribute("registerForm") User user,Model model)
	{
		System.out.println(user);
		
		model.addAttribute("user",user);
		System.out.println(user.getEmail());
//		String result=service.findByEmail(user.getEmail());
			service.save(user);
			System.out.println("Success");
			return "redirect:/signin";
		
	}
	
	@RequestMapping(value="/login-validation",method=RequestMethod.POST)
	public String UserLogin(@ModelAttribute("loginForm") User user,HttpSession session)
	{
		
		System.out.println(user);
		User userDetail=service.findByEmail(user.getEmail());
		
		
		if(userDetail!=null) {
			if(userDetail.getPassword().equals(user.getPassword())) {
				System.out.println(userDetail.toString());
				session.setAttribute("Loggeduser",userDetail);
				if(userDetail.getRole().equals("Admin")) {
					return "redirect:/adminhome";
				}
				else if(userDetail.getRole().equals("User")) {
					return "redirect:/userhome";
				}
			}
		}
		
		
		return "redirect:/loginfailed";
		
	}
	
	
	
	
	
}
