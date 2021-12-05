package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@RequestMapping(value="/registerForm",method= RequestMethod.POST)
	public String UserRegister(@ModelAttribute("registerForm") User user,Model model)
	{
		model.addAttribute("user",user);
		service.save(user);
		System.out.println("Success");
		return "Login";
	}
	
}
