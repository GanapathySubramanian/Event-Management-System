package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.demo.model.Event;
import com.app.demo.model.Booking;
import com.app.demo.model.Catering;

import com.app.demo.model.Hotel;
import com.app.demo.model.Vendor;
import com.app.demo.services.BookingServices;
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
	
	@Autowired
	private BookingServices	bookingservice;
	
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
	public String superAdminBookingDetails(ModelMap model) {
		List<Booking> booking=bookingservice.findAll();
		model.addAttribute("superadmin_booking",booking);
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
	
	@RequestMapping(value="/bookcancelbysuperadmin",method= RequestMethod.POST)
	public String UserBookingCancelAdmin(@RequestParam("booking_id") int booking_id)
	{
			bookingservice.bookingcancelByAdmin(booking_id);
			return "redirect:/superadminbookingdetails";
	}
	
	
	@RequestMapping(value="/bookacceptbysuperadmin",method= RequestMethod.POST)
	public String UserBookingAcceptAdmin(@RequestParam("booking_id") int booking_id)
	{
			bookingservice.bookingacceptByAdmin(booking_id);
			return "redirect:/superadminbookingdetails";
	
	}

}
