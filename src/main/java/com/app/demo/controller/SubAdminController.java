package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.demo.model.Hotel;
import com.app.demo.services.HotelServices;

@Controller

public class SubAdminController {
	
	@Autowired
	private HotelServices hotelservice;
	
	@RequestMapping(value="/subadmincateringdetails",method=RequestMethod.GET)
	public String subAdminCateringDetails() {
	    return "SubAdminCateringDetails"; 
	}
	
	@RequestMapping(value="/subadminhoteldetails",method=RequestMethod.GET)
	public String subAdminHotelDetails(ModelMap model) {
	    List<Hotel> hotel=hotelservice.findAll();
		model.addAttribute("Hotellist",hotel);
	    return "SubAdminHotelDetails"; 
	}
	
	@RequestMapping(value="/subadminvendordetails",method=RequestMethod.GET)
	public String subAdminVendorDetails() {
	    return "SubAdminVendorDetails";  
	}
	
	@RequestMapping(value="/subadminbookingdetails",method=RequestMethod.GET)
	public String subAdminBookingDetails() {
	    return "SubAdminBookingDetails";  
	}
	
	
	@RequestMapping(value="/subadmineventdetails",method=RequestMethod.GET)
	public String subAdminEventDetails() {
	    return "SubAdminEventDetails";  
	}
	
	@RequestMapping(value="/subadminaccount",method=RequestMethod.GET)
	public String subAdminAccount() {
	    return "SubAdminAccount";  
	}
}
