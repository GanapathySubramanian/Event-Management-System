package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.demo.model.Hotel;
import com.app.demo.services.HotelServices;

@Controller
public class AdminController {
		
	@Autowired
	private HotelServices hotelservice;
	
	@RequestMapping(value="/adminuserdetails",method=RequestMethod.GET)
	public String adminUserDetails() {
	    return "AdminUserDetails";  
	}
	
	@RequestMapping(value="/adminhoteldetails",method=RequestMethod.GET)
	public String adminHotelDetails(ModelMap model) {
		List<Hotel> hotel=hotelservice.findAll();
		model.addAttribute("Hotellist",hotel);
	    return "AdminHotelDetails"; 
		
	}
	
	@RequestMapping(value="/admincateringdetails",method=RequestMethod.GET)
	public String adminCateringDetails() {
	    return "AdminCateringDetails"; 
	}
	
	@RequestMapping(value="/adminvendordetails",method=RequestMethod.GET)
	public String adminVendorDetails() {
	    return "AdminVendorDetails";  
	}
	
	@RequestMapping(value="/adminbookingdetails",method=RequestMethod.GET)
	public String adminBookingDetails() {
	    return "AdminBookingDetails";  
	}
	
	@RequestMapping(value="/adminaccount",method=RequestMethod.GET)
	public String adminAccount() {
	    return "AdminAccount";  
	}
}
