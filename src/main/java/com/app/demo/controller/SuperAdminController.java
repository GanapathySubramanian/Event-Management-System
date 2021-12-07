package com.app.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class SuperAdminController {
	@RequestMapping(value="/superadmincateringdetails",method=RequestMethod.GET)
	public String superAdminCateringDetails() {
	    return "SuperAdminCateringDetails"; 
	}
	
	@RequestMapping(value="/superadminhoteldetails",method=RequestMethod.GET)
	public String superAdminHotelDetails() {
	    return "SuperAdminHotelDetails"; 
	}
	
	@RequestMapping(value="/superadminvendordetails",method=RequestMethod.GET)
	public String superAdminVendorDetails() {
	    return "SuperAdminVendorDetails";  
	}
	
	@RequestMapping(value="/superadminbookingdetails",method=RequestMethod.GET)
	public String superAdminBookingDetails() {
	    return "SuperAdminBookingDetails";  
	}
	
	
	@RequestMapping(value="/superadmineventdetails",method=RequestMethod.GET)
	public String superAdminEventDetails() {
	    return "SuperAdminEventDetails";  
	}
	
	@RequestMapping(value="/superadminaccount",method=RequestMethod.GET)
	public String adminAccount() {
	    return "SuperAdminAccount";  
	}
}
