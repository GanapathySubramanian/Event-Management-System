package com.app.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.demo.model.Booking;
import com.app.demo.model.Catering;
import com.app.demo.model.Event;
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

public class UserController {
	
	@Autowired
	private UserServices userservice;
	
	@Autowired
	private HotelServices hotelservice;
	
	@Autowired
	private CateringServices caterservice;
	
	@Autowired
	private VendorServices vendorservice;
	
	@Autowired
	private EventServices eventservice;
	
	@Autowired
	private BookingServices bookingservice;
	
	@RequestMapping(value="/registerForm",method= RequestMethod.POST)
	public String UserRegister(@ModelAttribute("registerForm") User user,Model model)
	{
		System.out.println(user);
		
		model.addAttribute("user",user);
		System.out.println(user.getEmail());
//		String result=service.findByEmail(user.getEmail());
			userservice.save(user);
			System.out.println("Success");
			
			return "redirect:/signin";
		
	}
	
	@RequestMapping(value="/login-validation",method=RequestMethod.POST)
	public String UserLogin(@ModelAttribute("loginForm") User user,HttpSession session)
	{
		
		System.out.println(user);
		User userDetail=userservice.findByEmail(user.getEmail());
		
		
		if(userDetail!=null) {
			if(userDetail.getPassword().equals(user.getPassword())) {
				System.out.println(userDetail.toString());
				
				if(userDetail.getRole().equals("Admin")) {
					session.setAttribute("Admin_firstname",userDetail.getFirstName());
					session.setAttribute("Admin_lastname", userDetail.getLastName());
					session.setAttribute("Admin_email", userDetail.getEmail());
					session.setAttribute("Admin_phone", userDetail.getContactno());
					session.setAttribute("Admin_address", userDetail.getAddress());
					session.setAttribute("Admin_gender", userDetail.getGender());
					session.setAttribute("Admin_id", userDetail.getId());
					return "redirect:/adminhome";
				}
					
				
				else if(userDetail.getRole().equals("User")) {
					session.setAttribute("User_firstname",userDetail.getFirstName());
					session.setAttribute("User_lastname", userDetail.getLastName());
					session.setAttribute("User_email", userDetail.getEmail());
					session.setAttribute("User_phone", userDetail.getContactno());
					session.setAttribute("User_address", userDetail.getAddress());
					session.setAttribute("User_gender", userDetail.getGender());
					session.setAttribute("User_id", userDetail.getId());
					return "redirect:/userhome";
				}
				else if(userDetail.getRole().equals("SubAdmin")) {
					session.setAttribute("Subadmin_firstname",userDetail.getFirstName());
					session.setAttribute("Subadmin_lastname", userDetail.getLastName());
					session.setAttribute("Subadmin_email", userDetail.getEmail());
					session.setAttribute("Subadmin_phone", userDetail.getContactno());
					session.setAttribute("Subadmin_address", userDetail.getAddress());
					session.setAttribute("Subadmin_gender", userDetail.getGender());
					session.setAttribute("Subadmin_id", userDetail.getId());
					return "redirect:/subadminhome";
				}
				else if(userDetail.getRole().equals("SuperAdmin")) {
					session.setAttribute("Superadmin_firstname",userDetail.getFirstName());
					session.setAttribute("Superadmin_lastname", userDetail.getLastName());
					session.setAttribute("Superadmin_email", userDetail.getEmail());
					session.setAttribute("Superadmin_phone", userDetail.getContactno());
					session.setAttribute("Superadmin_address", userDetail.getAddress());
					session.setAttribute("Superadmin_gender", userDetail.getGender());
					session.setAttribute("Superadmin_id", userDetail.getId());
					return "redirect:/superadminhome";
				}
			}
		}
		
		return "redirect:/loginfailed";
		
	}
	
	@RequestMapping(value="/subadminhome",method=RequestMethod.GET)
	public String subAdminHome() {
	    return "SubAdminHome";  
	}
	
	@RequestMapping(value="/superadminhome",method=RequestMethod.GET)
	public String superAdminHome() {
	    return "SuperAdminHome";  
	}
	
	@RequestMapping(value="/usernewbooking",method=RequestMethod.GET)
	public String userBookingForm(ModelMap model) {
		
		List<Hotel> hotel=hotelservice.findAll();
		model.addAttribute("hotel_for_booking",hotel);
		
		List<Catering> catering=caterservice.findAll();
		model.addAttribute("catering_for_booking",catering);
		
		List<Vendor> vendor=vendorservice.findAll();
		model.addAttribute("vendor_for_booking",vendor);
		
		List<Event> event=eventservice.findAll();
		model.addAttribute("event_for_booking",event);
		
	    return "UserBookingForm"; 
	}
	@RequestMapping(value="/userbookingdetails",method=RequestMethod.GET)
	public String userBookingDetails(HttpSession session,ModelMap model) {
		int id=(int) session.getAttribute("User_id");
		User user=userservice.findById(id);
		
		List<Booking> bookings=bookingservice.findAllByUser(user);
		
		
		
		System.out.println(id);
		
		System.out.println(bookings);
	    
		return "UserBookingDetails"; 
	}
	@RequestMapping(value="/useraccount",method=RequestMethod.GET)
	public String userAccount() {
	    return "UserAccount";  
	}

	
	@RequestMapping(value="/usercateringdetails",method=RequestMethod.GET)
	public String userCateringDetails(ModelMap model) {
		List<Catering> cater= caterservice.findAll();
		model.addAttribute("caterlist", cater);
	    return "UserCateringDetails"; 
	}
	
	@RequestMapping(value="/userhoteldetails",method=RequestMethod.GET)
	public String userHotelDetails(ModelMap  model) {
		List<Hotel> hotel =hotelservice.findAll();
		model.addAttribute("hotellist", hotel);
	    return "UserHotelDetails"; 
	}
	
	@RequestMapping(value="/uservendordetails",method=RequestMethod.GET)
	public String userVendorDetails(ModelMap model) 
	{
		List<Vendor> vendor=vendorservice.findAll();
		model.addAttribute("vendorlist", vendor);
	    return "UserVendorDetails";  
	}
	
	
	
	@RequestMapping(value="/usereventdetails",method=RequestMethod.GET)
	public String userEventDetails(ModelMap model) {
		List<Event> event =eventservice.findAll();
		model.addAttribute("eventlist", event);
	    return "UserEventDetails";  
	}

	
	@RequestMapping(value="hotelbookfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> hotelPriceDetails(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Hotel>(hotelservice.findById(id),HttpStatus.OK);
		}
	    catch(Exception e) {
	    	return new ResponseEntity<Hotel>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	@RequestMapping(value="cateringbookfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Catering> cateringPriceDetails(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Catering>(caterservice.findById(id),HttpStatus.OK);
		}
	    catch(Exception e) {
	    	return new ResponseEntity<Catering>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	
	@RequestMapping(value="eventbookfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> eventPriceDetails(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Event>(eventservice.findById(id),HttpStatus.OK);
		}
	    catch(Exception e) {
	    	return new ResponseEntity<Event>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	
	@RequestMapping(value="vendorbookfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vendor> vendorPriceDetails(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Vendor>(vendorservice.findById(id),HttpStatus.OK);
		}
	    catch(Exception e) {
	    	return new ResponseEntity<Vendor>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	
	@RequestMapping(value="/makeBookingForm",method= RequestMethod.POST)
	public String UserBooking(@ModelAttribute("makeBookingForm") Booking booking,@RequestParam("user_id") int user_id,@RequestParam("hotel_id") int hotel_id,@RequestParam("event_id") int event_id,@RequestParam("catering_id") int catering_id)
	{
		
			User user=userservice.findById(user_id);
			Hotel hotel=hotelservice.findById(hotel_id);
			Catering catering=caterservice.findById(catering_id);
			Event event=eventservice.findById(event_id);
			
			booking.setHotel(hotel);
			booking.setCatering(catering);
			booking.setEvent(event);
			booking.setUser(user);
			System.out.println(booking);
			bookingservice.save(booking);
			System.out.println("Success");
			
			return "redirect:/userbookingdetails";
	
	
		
	}
	
}
