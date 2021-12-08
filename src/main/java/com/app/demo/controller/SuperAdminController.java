package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.app.demo.model.Event;
import com.app.demo.model.Catering;

import com.app.demo.model.Hotel;
import com.app.demo.model.Vendor;
import com.app.demo.services.CateringServices;
import com.app.demo.services.EventServices;
import com.app.demo.services.HotelServices;
import com.app.demo.services.VendorServices;


@Controller
public class SuperAdminController {
	
	@Autowired
	private HotelServices hotelservice;
	
	@Autowired
	private VendorServices vendorservice;
	
	@Autowired
	private CateringServices caterservice;
	
	@Autowired
	private EventServices eventservices;
	
	@RequestMapping(value="/superadmincateringdetails",method=RequestMethod.GET)
	public String superAdminCateringDetails(ModelMap model) {
		List<Catering> cater =caterservice.findAll();
		model.addAttribute("caterlist", cater);
	    return "SuperAdminCateringDetails"; 
	}
	
	@RequestMapping(value="/superadminhoteldetails",method=RequestMethod.GET)
	public String superAdminHotelDetails(ModelMap model) {
		List<Hotel> hotel = hotelservice.findAll();
		model.addAttribute("hotellist", hotel);
	    return "SuperAdminHotelDetails"; 
	}
	
	@RequestMapping(value="/superadminvendordetails",method=RequestMethod.GET)
	public String superAdminVendorDetails(ModelMap model) {
		List<Vendor> vendor=vendorservice.findAll();
		model.addAttribute("vendorlist",vendor);		
	    return "SuperAdminVendorDetails";  
	}
	
	@RequestMapping(value="/superadminbookingdetails",method=RequestMethod.GET)
	public String superAdminBookingDetails() {
	    return "SuperAdminBookingDetails";  
	}
	
	
	@RequestMapping(value="/superadmineventdetails",method=RequestMethod.GET)
	public String superAdminEventDetails(ModelMap model) {
		List<Event> event = eventservices.findAll();
		model.addAttribute("eventlist", event);
	    return "SuperAdminEventDetails";  
	}
	
	@RequestMapping(value="/superadminaccount",method=RequestMethod.GET)
	public String adminAccount() {
	    return "SuperAdminAccount";  
	}
}
