package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class GeneralController {
	

	@RequestMapping(value="/",method= RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/signin",method= RequestMethod.GET)
	public String login() {
		return "Login";
	}
	
	@RequestMapping(value="/signup",method= RequestMethod.GET)
	public String register() {
		return "UserRegisteration";
	}
	
	
	@RequestMapping(value="/contactus",method= RequestMethod.GET)
	public String contactus() {
		return "ContactUs";
	}
	
	@RequestMapping(value="/aboutus",method= RequestMethod.GET)
	public String aboutus() {
		return "Aboutus";
	}
	
	
	


	
}
