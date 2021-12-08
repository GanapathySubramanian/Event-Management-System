package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.demo.model.Catering;
import com.app.demo.model.Event;
import com.app.demo.model.Hotel;
import com.app.demo.model.Vendor;
import com.app.demo.services.CateringServices;
import com.app.demo.services.EventServices;
import com.app.demo.services.HotelServices;
import com.app.demo.services.VendorServices;



@Controller

public class SubAdminController {
	
	@Autowired
	private HotelServices hotelservice;
	
	@Autowired
	private VendorServices vendorservice;
	
	@Autowired
	private CateringServices caterservice;
	
	@Autowired
	private EventServices eventservice;
	
	@RequestMapping(value="/subadmincateringdetails",method=RequestMethod.GET)
	public String subAdminCateringDetails(ModelMap model) {
		List<Catering> cater=caterservice.findAll();
		model.addAttribute("caterlist", cater);
	    return "SubAdminCateringDetails"; 
	}
	
	@RequestMapping(value="/subadminhoteldetails",method=RequestMethod.GET)
	public String subAdminHotelDetails(ModelMap model) {
	    List<Hotel> hotel=hotelservice.findAll();
		model.addAttribute("hotellist",hotel);
	    return "SubAdminHotelDetails"; 
	}
	
	@RequestMapping(value="/subadminvendordetails",method=RequestMethod.GET)
	public String subAdminVendorDetails(ModelMap model) {
		List<Vendor> vendor=vendorservice.findAll();
		model.addAttribute("vendorlist",vendor);
	    return "SubAdminVendorDetails";  
	}
	
	@RequestMapping(value="/subadminbookingdetails",method=RequestMethod.GET)
	public String subAdminBookingDetails() {
	    return "SubAdminBookingDetails";  
	}
	
	
	@RequestMapping(value="/subadmineventdetails",method=RequestMethod.GET)
	public String subAdminEventDetails(ModelMap model) {
		List<Event> event=eventservice.findAll();
		model.addAttribute("eventlist",event);
	    return "SubAdminEventDetails";  
	}
	
	@RequestMapping(value="/subadminaccount",method=RequestMethod.GET)
	public String subAdminAccount() {
	    return "SubAdminAccount";  
	}
}
