package com.app.demo.controller;


import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.demo.model.User;
import com.app.demo.services.BookingServices;
import com.app.demo.services.CateringServices;
import com.app.demo.services.EventServices;
import com.app.demo.services.HotelServices;
import com.app.demo.services.UserServices;
import com.app.demo.services.VendorServices;


@Controller
public class GeneralController {
	
	@Autowired
	private UserServices userservice;
	
	@Autowired
	private HotelServices hotelservice;
	
	@Autowired
	private EventServices eventservice;
	
	@Autowired
	private CateringServices caterservice;
	
	@Autowired
	private VendorServices vendorservice;
	
	@Autowired
	private BookingServices bookingservice;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/",method= RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/signin",method= RequestMethod.GET)
	public String login() {
		return "Login";
	}
	
	@RequestMapping(value="/signup",method= RequestMethod.GET)
	public String register() {
		return "UserRegisteration";
	}
	
	
	@RequestMapping(value="/contactus",method= RequestMethod.GET)
	public String contactus() {
		return "ContactUs";
	}
	
	@RequestMapping(value="/aboutus",method= RequestMethod.GET)
	public String aboutus() {
		return "Aboutus";
	}
	
	@RequestMapping(value="/userhome",method=RequestMethod.GET)
	public String userhome(ModelMap model,HttpSession session) {
		if(session.getAttribute("User_id")==null) {
			return "redirect:/signin";
		}else {
		int id=(int) session.getAttribute("User_id");
//		User user=userservice.findById(id);
		
		long Hotelcount=hotelservice.hotelCount();
		model.addAttribute("user_hotel_count",Hotelcount);
		
		long Eventcount=eventservice.eventCount();
		model.addAttribute("user_event_count",Eventcount);
		
		long Cateringcount=caterservice.cateringcount();
		model.addAttribute("user_catering_count",Cateringcount);
		
		long Vendorcount=vendorservice.vendorcount();
		model.addAttribute("user_vendor_count",Vendorcount);
		
		long Bookingcount=bookingservice.bookingcountById(id);
		model.addAttribute("user_booking_count",Bookingcount);
		
		long BookingcountPaid=bookingservice.bookingcountPaidById(id);
		model.addAttribute("user_bookingpaid_count",BookingcountPaid);
		
		long BookingcountunPaid=bookingservice.bookingcountunPaidById(id);
		model.addAttribute("user_bookingunpaid_count",BookingcountunPaid);
		
		long BookingcanceledbyAdmin=bookingservice.bookingcountcancelByAdminById(id);
		model.addAttribute("user_bookingcancelbyadmin_count",BookingcanceledbyAdmin);
		
		long BookingcanceledbyUser=bookingservice.bookingcountcancelByUserById(id);
		model.addAttribute("user_bookingcancelbyuser_count",BookingcanceledbyUser);
		
		long BookingPendingByUser=bookingservice.bookingPendingcountById(id);
		model.addAttribute("user_bookingpending_count",BookingPendingByUser);
		
		
		
		return "Userhome";
		}
	}
	
	@RequestMapping(value="/adminhome",method=RequestMethod.GET)
	public String adminhome(ModelMap model) {
		
		long Usercount=userservice.userCount();
		model.addAttribute("admin_user_count",Usercount);
		
		long Hotelcount=hotelservice.hotelCount();
		model.addAttribute("admin_hotel_count",Hotelcount);
		
		long Eventcount=eventservice.eventCount();
		model.addAttribute("admin_event_count",Eventcount);
		
		long Cateringcount=caterservice.cateringcount();
		model.addAttribute("admin_catering_count",Cateringcount);
		
		long Vendorcount=vendorservice.vendorcount();
		model.addAttribute("admin_vendor_count",Vendorcount);
		
		long Bookingcount=bookingservice.bookingcount();
		model.addAttribute("admin_booking_count",Bookingcount);
		
		long BookingcountPaid=bookingservice.bookingcountPaid();
		model.addAttribute("admin_bookingpaid_count",BookingcountPaid);
		
		long BookingcountunPaid=bookingservice.bookingcountunPaid();
		model.addAttribute("admin_bookingunpaid_count",BookingcountunPaid);
		
		long BookingcanceledbyAdmin=bookingservice.bookingcountcancelByAdmin();
		model.addAttribute("admin_bookingcancelbyadmin_count",BookingcanceledbyAdmin);
		
		long BookingcanceledbyUser=bookingservice.bookingcountcancelByUser();
		model.addAttribute("admin_bookingcancelbyuser_count",BookingcanceledbyUser);
		
		long Bookingpending=bookingservice.bookingpendingcount();
		model.addAttribute("admin_bookingpending_count",Bookingpending);
		
		return "AdminHome";
	}
	
	@RequestMapping(value="/subadminhome",method=RequestMethod.GET)
	public String subAdminHome(ModelMap model) {
		long Usercount=userservice.userCount();
		model.addAttribute("subadmin_user_count",Usercount);
		
		long Hotelcount=hotelservice.hotelCount();
		model.addAttribute("subadmin_hotel_count",Hotelcount);
		
		long Eventcount=eventservice.eventCount();
		model.addAttribute("subadmin_event_count",Eventcount);
		
		long Cateringcount=caterservice.cateringcount();
		model.addAttribute("subadmin_catering_count",Cateringcount);
		
		long Vendorcount=vendorservice.vendorcount();
		model.addAttribute("subadmin_vendor_count",Vendorcount);
		
		long Bookingcount=bookingservice.bookingcount();
		model.addAttribute("subadmin_booking_count",Bookingcount);
		
		long BookingcountPaid=bookingservice.bookingcountPaid();
		model.addAttribute("subadmin_bookingpaid_count",BookingcountPaid);
		
		long BookingcountunPaid=bookingservice.bookingcountunPaid();
		model.addAttribute("subadmin_bookingunpaid_count",BookingcountunPaid);
		
		long BookingcanceledbyAdmin=bookingservice.bookingcountcancelByAdmin();
		model.addAttribute("subadmin_bookingcancelbyadmin_count",BookingcanceledbyAdmin);
		
		long BookingcanceledbyUser=bookingservice.bookingcountcancelByUser();
		model.addAttribute("subadmin_bookingcancelbyuser_count",BookingcanceledbyUser);
		
		long Bookingpending=bookingservice.bookingpendingcount();
		model.addAttribute("subadmin_bookingpending_count",Bookingpending);
		
	    return "SubAdminHome";  
	}
	
	@RequestMapping(value="/superadminhome",method=RequestMethod.GET)
	public String superAdminHome(ModelMap model) {
		
		long Usercount=userservice.userCount();
		model.addAttribute("superadmin_user_count",Usercount);
		
		long Hotelcount=hotelservice.hotelCount();
		model.addAttribute("superadmin_hotel_count",Hotelcount);
		
		long Eventcount=eventservice.eventCount();
		model.addAttribute("superadmin_event_count",Eventcount);
		
		long Cateringcount=caterservice.cateringcount();
		model.addAttribute("superadmin_catering_count",Cateringcount);
		
		long Vendorcount=vendorservice.vendorcount();
		model.addAttribute("superadmin_vendor_count",Vendorcount);
		
		long Bookingcount=bookingservice.bookingcount();
		model.addAttribute("superadmin_booking_count",Bookingcount);
		
		long BookingcountPaid=bookingservice.bookingcountPaid();
		model.addAttribute("superadmin_bookingpaid_count",BookingcountPaid);
		
		long BookingcountunPaid=bookingservice.bookingcountunPaid();
		model.addAttribute("superadmin_bookingunpaid_count",BookingcountunPaid);
		
		
		long BookingcanceledbyAdmin=bookingservice.bookingcountcancelByAdmin();
		model.addAttribute("superadmin_bookingcancelbyadmin_count",BookingcanceledbyAdmin);
		
		long BookingcanceledbyUser=bookingservice.bookingcountcancelByUser();
		model.addAttribute("superadmin_bookingcancelbyuser_count",BookingcanceledbyUser);
		
		long Bookingpending=bookingservice.bookingpendingcount();
		model.addAttribute("superadmin_bookingpending_count",Bookingpending);
		
	    return "SuperAdminHome";  
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
	    if (session != null) {
	        session.invalidate();
	    }
	    return "redirect:/signin"; 
	}
	
	@RequestMapping(value="/loginfailed",method=RequestMethod.GET)
	public String loginfailed() {
	    return "LoginFailed";
	}
	
	@RequestMapping(value="/contactForm",method=RequestMethod.POST)
	public String Contactus(@RequestParam("FirstName") String f_name,@RequestParam("LastName") String l_name,@RequestParam("Email") String email,@RequestParam("Message") String msg,ModelMap model) throws MessagingException, UnsupportedEncodingException {
		
		try {
			
	    MimeMessage message= mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    
	    User user=userservice.findByRole("Admin");
	    
	    
	    helper.setFrom(email, "EXQUISITE");
	    helper.setTo(user.getEmail());
	     
	    String subject = "User Query";
	     
	    String content = "<p>First Name : "+f_name+"</p>"
	            + "<p>Last Name : "+l_name+"</p>"
	            + "<p> Email : "+email+"</p>"
	            + "<br>"
	            + "<p>Message / Query / FeedBack : </p>"
	            + "<br>"
	            + "<h1 style='color:orange'>"+msg+"</h1>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
		}
	    catch(Exception e) {
	    model.addAttribute("error","Your Message/Query/Feedback  Send is Failed !!");
	    	return "ContactUs";
	    }
		model.addAttribute("success","your Message is sended successfully please wait we will get back to you as soon as possible");
		return "ContactUs";
		
	}
	
	
	
	
}
