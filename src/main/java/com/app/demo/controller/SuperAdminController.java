
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

import com.app.demo.model.Event;
import com.app.demo.model.Booking;
import com.app.demo.model.Catering;

import com.app.demo.model.Hotel;
import com.app.demo.model.User;
import com.app.demo.model.Vendor;
import com.app.demo.services.BookingServices;
import com.app.demo.services.CateringServices;
import com.app.demo.services.EventServices;
import com.app.demo.services.HotelServices;
import com.app.demo.services.UserServices;
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
	private UserServices userservice;
	
	
	@Autowired
	private BookingServices	bookingservice;
	
	@RequestMapping(value="/superadmincateringdetails",method=RequestMethod.GET)
	public String superAdminCateringDetails(ModelMap model) {
		List<Catering> cater =caterservice.findAll();
		model.addAttribute("caterlist", cater);
	    return "SuperAdminCateringDetails"; 
	}
	
	@RequestMapping(value="/superadmincateringSearch",method=RequestMethod.POST)
	public String superadminCateringSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Catering> cater =caterservice.findAll();
			model.addAttribute("caterlist", cater);
		    return "SuperAdminCateringDetails"; 
		}
		else {
			model.addAttribute("catering_keyword",searchkey);
			List<Catering> cater =caterservice.findBykey(searchkey);
			model.addAttribute("caterlist", cater);
		    return "SuperAdminCateringDetails";  
		}
	}
	@RequestMapping(value="/superadminhoteldetails",method=RequestMethod.GET)
	public String superAdminHotelDetails(ModelMap model) {
		List<Hotel> hotel = hotelservice.findAll();
		model.addAttribute("hotellist", hotel);
	    return "SuperAdminHotelDetails"; 
	}
	
	@RequestMapping(value="/superadminhotelSearch",method=RequestMethod.POST)
	public String superadminHotelSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Hotel> hotel = hotelservice.findAll();
			model.addAttribute("hotellist", hotel);
		    return "SuperAdminHotelDetails";
		}
		else {
			model.addAttribute("hotel_keyword",searchkey);
			List<Hotel> hotel = hotelservice.findBykey(searchkey);
			model.addAttribute("hotellist", hotel);
		    return "SuperAdminHotelDetails";   
			
		}
	}
	@RequestMapping(value="/superadminvendordetails",method=RequestMethod.GET)
	public String superAdminVendorDetails(ModelMap model) {
		List<Vendor> vendor=vendorservice.findAll();
		model.addAttribute("vendorlist",vendor);		
	    return "SuperAdminVendorDetails";  
	}
	
	@RequestMapping(value="/superadminvendorSearch",method=RequestMethod.POST)
	public String superadminVendorSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Vendor> vendor=vendorservice.findAll();
			model.addAttribute("vendorlist",vendor);		
		    return "SuperAdminVendorDetails"; 
		}
		else {
			model.addAttribute("vendor_keyword",searchkey);
			List<Vendor> vendor=vendorservice.findBykey(searchkey);
			model.addAttribute("vendorlist",vendor);		
		    return "SuperAdminVendorDetails";  
			
		}
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
	
	
	@RequestMapping(value="/superadmineventSearch",method=RequestMethod.POST)
	public String superadminEventSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Event> event = eventservices.findAll();
			model.addAttribute("eventlist", event);
		    return "SuperAdminEventDetails"; 
		}
		else {
			model.addAttribute("event_keyword",searchkey);
			List<Event> event = eventservices.findBykey(searchkey);
			model.addAttribute("eventlist", event);
		    return "SuperAdminEventDetails"; 
			
		}
	}
	@RequestMapping(value="/superadminaccount",method=RequestMethod.GET)
	public String adminAccount() {
	    return "SuperAdminAccount";  
	}
	
	@RequestMapping(value="/editsuperadminprofile",method=RequestMethod.POST)
	public String updateUserProfile(@ModelAttribute("superadminEditProfile") User superadmin ,HttpSession session) {
		System.out.println(superadmin);
		
		userservice.updateUserProfile(superadmin.getEmail(),superadmin.getFirstName(),superadmin.getLastName(),superadmin.getGender(),superadmin.getContactno(),superadmin.getAddress(),superadmin.getRole(),superadmin.getPassword(),superadmin.getConfirmPassword(),superadmin.getId());
		session.setAttribute("Superadmin_firstname",superadmin.getFirstName());
		session.setAttribute("Superadmin_lastname", superadmin.getLastName());
		session.setAttribute("Superadmin_email", superadmin.getEmail());
		session.setAttribute("Superadmin_phone", superadmin.getContactno());
		session.setAttribute("Superadmin_address", superadmin.getAddress());
		session.setAttribute("Superadmin_gender", superadmin.getGender());
		session.setAttribute("Superadmin_id", superadmin.getId());
		session.setAttribute("Superadmin_role", superadmin.getRole());
		session.setAttribute("Superadmin_cpassword", superadmin.getConfirmPassword());
		session.setAttribute("Superadmin_password", superadmin.getPassword());
	
		return "redirect:/superadminaccount";
		
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
	
	 @RequestMapping(value="/superadminlogout",method=RequestMethod.GET)
		public String superadminlogout(HttpSession session) {
		    if (session != null) {
		        // session.removeAttribute(null)
		        session.removeAttribute("Superadmin_firstname");
				session.removeAttribute("Superadmin_lastname");
				session.removeAttribute("Superadmin_email");
				session.removeAttribute("Superadmin_phone");
				session.removeAttribute("Superadmin_address");
				session.removeAttribute("Superadmin_gender");
				session.removeAttribute("Superadmin_id");
				session.removeAttribute("Superadmin_cpassword");
				session.removeAttribute("Superadmin_password");
				session.removeAttribute("Superadmin_role");
		    }
		    return "redirect:/signin"; 
		}

}
