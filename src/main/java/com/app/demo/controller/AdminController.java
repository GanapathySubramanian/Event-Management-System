package com.app.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.demo.model.Hotel;
import com.app.demo.model.User;
import com.app.demo.services.HotelServices;
import com.app.demo.services.UserServices;

@Controller

public class AdminController {
		
	@Autowired
	private HotelServices hotelservice;
	
	@Autowired
	private  UserServices userservice;
	
	
	@RequestMapping(value="/adduserForm",method= RequestMethod.POST)
	public String UserRegister(@ModelAttribute("registerForm") User user,Model model)
	{
			System.out.println(user);
			
			model.addAttribute("user",user);
		
			userservice.save(user);
			System.out.println("add user Success");
			
			return "redirect:/adminuserdetails";
		
	}
	
	
	@RequestMapping(value="/adminuserdetails",method=RequestMethod.GET)
	public String adminUserDetails(ModelMap model) {
//		String keyword="gana";
		List<User> user=userservice.findAll();
		model.addAttribute("Userlist",user);
	    return "AdminUserDetails";  
	}
	
	
	@RequestMapping(value="/admindeleteuser/{email}",method=RequestMethod.GET)
	public String admindeleteUser(@PathVariable String email) {
		
		User user=userservice.findByEmail(email);
		System.out.println(user);
		if(user.getEmail()!=null) {
			userservice.deleteUser(user.getId());
			 return "redirect:/adminuserdetails";
		}
		
	    return "redirect:/adminuserdetails";  
	}
	
	@RequestMapping(value="/adminhoteldetails",method=RequestMethod.GET)
	public String adminHotelDetails(ModelMap model) {
		List<Hotel> hotel=hotelservice.findAll();
		model.addAttribute("Hotellist",hotel);
	    return "AdminHotelDetails"; 
		
	}
	
	
	@RequestMapping(value="find/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> adminEditDetails(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<User>(userservice.findById(id),HttpStatus.OK);
		}
	    catch(Exception e) {
	    	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	@RequestMapping(value="/EdituserForm",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("userEditForm") User user) {
		System.out.println(user);
		userservice.updateUserDetails(user.getEmail(),user.getFirstName(),user.getLastName(),user.getGender(),user.getContactno(),user.getAddress(),user.getRole(),user.getId());
		return "redirect:/adminuserdetails";
		
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
	
	
	@RequestMapping(value="/admineventdetails",method=RequestMethod.GET)
	public String adminEventDetails() {
	    return "AdminEventDetails";  
	}
	
	@RequestMapping(value="/adminaccount",method=RequestMethod.GET)
	public String adminAccount() {
	    return "AdminAccount";  
	}
}
