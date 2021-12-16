package com.app.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.demo.model.Catering;
import com.app.demo.model.Event;
import com.app.demo.model.Hotel;
import com.app.demo.model.User;
import com.app.demo.model.Vendor;
import com.app.demo.services.CateringServices;
import com.app.demo.services.EventServices;
import com.app.demo.services.HotelServices;
import com.app.demo.services.UserServices;
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
	
	@Autowired
	private UserServices userservice;
	
	
	@RequestMapping(value="/subadmincateringdetails",method=RequestMethod.GET)
	public String subAdminCateringDetails(ModelMap model) {
		List<Catering> cater=caterservice.findAll();
		model.addAttribute("caterlist", cater);
	    return "SubAdminCateringDetails"; 
	}
	
	@RequestMapping(value="/subadmincateringSearch",method=RequestMethod.POST)
	public String subadminCateringSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Catering> cater=caterservice.findAll();
			model.addAttribute("caterlist", cater);
		    return "SubAdminCateringDetails";    
			
		}
		else {
			model.addAttribute("catering_keyword",searchkey);
			List<Catering> cater=caterservice.findBykey(searchkey);
			model.addAttribute("caterlist", cater);
		    return "SubAdminCateringDetails";   
			
		}
	}
	
	@RequestMapping(value="/subadminhoteldetails",method=RequestMethod.GET)
	public String subAdminHotelDetails(ModelMap model) {
	    List<Hotel> hotel=hotelservice.findAll();
		model.addAttribute("hotellist",hotel);
	    return "SubAdminHotelDetails"; 
	}
	
	@RequestMapping(value="/subadminhotelSearch",method=RequestMethod.POST)
	public String subadminHotelSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Hotel> hotel=hotelservice.findAll();
			model.addAttribute("hotellist",hotel);
		    return "SubAdminHotelDetails"; 
			
		}
		else {
			model.addAttribute("hotel_keyword",searchkey);
			List<Hotel> hotel=hotelservice.findBykey(searchkey);
			model.addAttribute("hotellist",hotel);
		    return "SubAdminHotelDetails"; 
			
		}
	}
	@RequestMapping(value="/subadminvendordetails",method=RequestMethod.GET)
	public String subAdminVendorDetails(ModelMap model) {
		List<Vendor> vendor=vendorservice.findAll();
		model.addAttribute("vendorlist",vendor);
	    return "SubAdminVendorDetails";  
	}
	
	@RequestMapping(value="/subadminvendorSearch",method=RequestMethod.POST)
	public String subadminVendorSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Vendor> vendor=vendorservice.findAll();
			model.addAttribute("vendorlist",vendor);
		    return "SubAdminVendorDetails";   
			
		}
		else {
			model.addAttribute("vendor_keyword",searchkey);
			List<Vendor> vendor=vendorservice.findBykey(searchkey);
			model.addAttribute("vendorlist",vendor);
		    return "SubAdminVendorDetails";  
			
		}
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
	
	@RequestMapping(value="/subadmineventSearch",method=RequestMethod.POST)
	public String subadminEventSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Event> event=eventservice.findAll();
			model.addAttribute("eventlist",event);
		    return "SubAdminEventDetails";    
			
		}
		else {
			model.addAttribute("event_keyword",searchkey);
			List<Event> event=eventservice.findBykey(searchkey);
			model.addAttribute("eventlist",event);
		    return "SubAdminEventDetails";  
			
		}
	}
	
	@RequestMapping(value="/subadminaccount",method=RequestMethod.GET)
	public String subAdminAccount() {
	    return "SubAdminAccount";  
	}
	
	@RequestMapping(value="/editsubadminprofile",method=RequestMethod.POST)
	public String updateUserProfile(@ModelAttribute("subadmineditprofile") User subadmin ,HttpSession session) {
		System.out.println(subadmin);
		
		userservice.updateUserProfile(subadmin.getEmail(),subadmin.getFirstName(),subadmin.getLastName(),subadmin.getGender(),subadmin.getContactno(),subadmin.getAddress(),subadmin.getRole(),subadmin.getPassword(),subadmin.getConfirmPassword(),subadmin.getId());
		session.setAttribute("Subadmin_firstname",subadmin.getFirstName());
		session.setAttribute("Subadmin_lastname", subadmin.getLastName());
		session.setAttribute("Subadmin_email", subadmin.getEmail());
		session.setAttribute("Subadmin_phone", subadmin.getContactno());
		session.setAttribute("Subadmin_address", subadmin.getAddress());
		session.setAttribute("Subadmin_gender", subadmin.getGender());
		session.setAttribute("Subadmin_id", subadmin.getId());
		session.setAttribute("Subadmin_role", subadmin.getRole());
		session.setAttribute("Subadmin_cpassword", subadmin.getConfirmPassword());
		session.setAttribute("Subadmin_password", subadmin.getPassword());
	
		return "redirect:/subadminaccount";
		
	}
	
	 @RequestMapping(value="/subadminlogout",method=RequestMethod.GET)
		public String subadminlogout(HttpSession session) {
		    if (session != null) {
		        // session.removeAttribute(null)
		        session.removeAttribute("Subadmin_firstname");
				session.removeAttribute("Subadmin_lastname");
				session.removeAttribute("Subadmin_email");
				session.removeAttribute("Subadmin_phone");
				session.removeAttribute("Subadmin_address");
				session.removeAttribute("Subadmin_gender");
				session.removeAttribute("Subadmin_id");
				session.removeAttribute("Subadmin_cpassword");
				session.removeAttribute("Subadmin_password");
				session.removeAttribute("Subadmin_role");
		    }
		    return "redirect:/signin"; 
		}
	
}
