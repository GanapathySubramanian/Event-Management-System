package com.app.demo.controller;

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
			return "Login";
		
	}
	
}
