package com.app.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.demo.model.User;
import com.app.demo.services.UserServices;

@Controller

public class UserController {
	
	@Autowired
	private UserServices service;
	
	
	@RequestMapping(value="/registerForm",method= RequestMethod.POST)
	public String UserRegister(@ModelAttribute("registerForm") User user,Model model)
	{
		System.out.println(user);
		
		model.addAttribute("user",user);
		System.out.println(user.getEmail());
//		String result=service.findByEmail(user.getEmail());
			service.save(user);
			System.out.println("Success");
			
			return "redirect:/signin";
		
	}
	
	@RequestMapping(value="/login-validation",method=RequestMethod.POST)
	public String UserLogin(@ModelAttribute("loginForm") User user,HttpSession session)
	{
		
		System.out.println(user);
		User userDetail=service.findByEmail(user.getEmail());
		
		
		if(userDetail!=null) {
			if(userDetail.getPassword().equals(user.getPassword())) {
				System.out.println(userDetail.toString());
				
				if(userDetail.getRole().equals("Admin")) {
					session.setAttribute("LoggedasAdmin",userDetail);
					return "redirect:/adminhome";
				}
				else if(userDetail.getRole().equals("User")) {
					session.setAttribute("username",userDetail.getFirstName());
					return "redirect:/userhome";
				}
				else if(userDetail.getRole().equals("SubAdmin")) {
					session.setAttribute("LoggedassubAdmin",userDetail);
					return "redirect:/subadminhome";
				}
				else if(userDetail.getRole().equals("SuperAdmin")) {
					session.setAttribute("LoggedasuperAdmin",userDetail);
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
	public String userBookingForm() {
	    return "UserBookingForm";  //Where you go after logout here.
	}
	@RequestMapping(value="/userbookingdetails",method=RequestMethod.GET)
	public String userBookingDetails() {
	    return "UserBookingDetails";  //Where you go after logout here.
	}
	@RequestMapping(value="/useraccount",method=RequestMethod.GET)
	public String userAccount() {
	    return "UserAccount";  //Where you go after logout here.
	}

	
	
	@RequestMapping(value="/usercateringdetails",method=RequestMethod.GET)
	public String userCateringDetails() {
	    return "UserCateringDetails"; 
	}
	
	@RequestMapping(value="/userhoteldetails",method=RequestMethod.GET)
	public String userHotelDetails() {
	    return "UserHotelDetails"; 
	}
	
	@RequestMapping(value="/uservendordetails",method=RequestMethod.GET)
	public String userVendorDetails() {
	    return "UserVendorDetails";  
	}
	
	
	
	@RequestMapping(value="/usereventdetails",method=RequestMethod.GET)
	public String userEventDetails() {
	    return "UserEventDetails";  
	}
	

	
	
	
}
