package com.app.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="/userhome",method=RequestMethod.GET)
	public String userhome() {
		return "Userhome";
	}
	
	@RequestMapping(value="/adminhome",method=RequestMethod.GET)
	public String adminhome() {
		return "AdminHome";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout() {
	    return "redirect:/signin";  //Where you go after logout here.
	}
	
	@RequestMapping(value="/loginfailed",method=RequestMethod.GET)
	public String loginfailed() {
	    return "LoginFailed";  //Where you go after logout here.
	}
	
}
