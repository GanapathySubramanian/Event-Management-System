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
	
	@RequestMapping(value="/usernewbooking",method=RequestMethod.GET)
	public String userBookingForm() {
	    return "UserBookingForm";  //Where you go after logout here.
	}
	@RequestMapping(value="/userbookingdetails",method=RequestMethod.GET)
	public String userBookingDetails() {
	    return "UserBookingDetails";  //Where you go after logout here.
	}
	@RequestMapping(value="/useraccount",method=RequestMethod.GET)
	public String userAccount() {
	    return "UserAccount";  //Where you go after logout here.
	}

	@RequestMapping(value="/adminuserdetails",method=RequestMethod.GET)
	public String adminUserDetails() {
	    return "AdminUserDetails";  //Where you go after logout here.
	}
	
	@RequestMapping(value="/adminhoteldetails",method=RequestMethod.GET)
	public String adminHotelDetails() {
	    return "AdminHotelDetails";  //Where you go after logout here.
	}
	
	@RequestMapping(value="/admincateringdetails",method=RequestMethod.GET)
	public String adminCateringDetails() {
	    return "AdminCateringDetails";  //Where you go after logout here.
	}
	
	@RequestMapping(value="/adminvendordetails",method=RequestMethod.GET)
	public String adminVendorDetails() {
	    return "AdminVendorDetails";  //Where you go after logout here.
	}
	
	@RequestMapping(value="/adminbookingdetails",method=RequestMethod.GET)
	public String adminBookingDetails() {
	    return "AdminBookingDetails";  //Where you go after logout here.
	}
	
	@RequestMapping(value="/adminaccount",method=RequestMethod.GET)
	public String adminAccount() {
	    return "AdminAccount";  //Where you go after logout here.
	}
	
}
