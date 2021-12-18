package com.app.demo.controller;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.demo.UserExcelExporter;
import com.app.demo.model.Booking;
import com.app.demo.model.Catering;
import com.app.demo.model.Event;
import com.app.demo.model.Hotel;
import com.app.demo.model.User;
import com.app.demo.model.Vendor;
import com.app.demo.repository.CateringRepo;
import com.app.demo.repository.HotelRepo;
import com.app.demo.repository.VendorRepo;
import com.app.demo.services.BookingServices;
import com.app.demo.services.CateringServices;
import com.app.demo.services.EventServices;
import com.app.demo.services.HotelServices;
import com.app.demo.services.UserServices;
import com.app.demo.services.VendorServices;

@Controller
public class AdminController {
		
	@Autowired
	private HotelServices hotelservice;
	
	@Autowired
	private  UserServices userservice;

	@Autowired
	private CateringServices caterservice;
	
	@Autowired
	private VendorServices vendorservice;

	@Autowired
	private EventServices eventservice;
	
	@Autowired
	private BookingServices bookingservice;
	

	//User Registration
	@RequestMapping(value="/adduserForm",method= RequestMethod.POST)
	public String UserRegister(@ModelAttribute("registerForm") User user,Model model)
	{
			System.out.println(user);
			
			model.addAttribute("user",user);
		
			userservice.save(user);
			System.out.println("add user Success");
			
			return "redirect:/adminuserdetails";
		
	}
	
	
	//User Table
	@RequestMapping(value="/adminuserdetails",method=RequestMethod.GET)
	public String adminUserDetails(ModelMap model) {
//		String keyword="gana";
		List<User> user=userservice.findAll();
		model.addAttribute("Userlist",user);
	    return "AdminUserDetails";  
	}
	
	@RequestMapping(value="/adminuserSearch",method=RequestMethod.POST)
	public String adminUserSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<User> listuser=userservice.findAll();
			model.addAttribute("Userlist",listuser);
			return "AdminUserDetails"; 
			
		}
		else {
			model.addAttribute("user_keyword",searchkey);
			List<User> listuser=userservice.findBykey(searchkey);
			model.addAttribute("Userlist",listuser);
			return "AdminUserDetails";
		}
	}
	
	
	
	
	
	//User Table Delete
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
	
	

	//Model find and fill for User
		@RequestMapping(value="userfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> adminEditDetails(@PathVariable("id") int id) {
			try {
				return new ResponseEntity<User>(userservice.findById(id),HttpStatus.OK);
			}
		    catch(Exception e) {
		    	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		    }
			
		}
	
		
		//Edit the user
		@RequestMapping(value="/EdituserForm",method=RequestMethod.POST)
		public String updateUser(@ModelAttribute("userEditForm") User user) {
			System.out.println(user);
			userservice.updateUserDetails(user.getEmail(),user.getFirstName(),user.getLastName(),user.getGender(),user.getContactno(),user.getAddress(),user.getRole(),user.getId());
			return "redirect:/adminuserdetails";
			
		}
		
	
	//Hotel Table
	@RequestMapping(value="/adminhoteldetails",method=RequestMethod.GET)
	public String adminHotelDetails(ModelMap model) {
		List<Hotel> hotel=hotelservice.findAll();
		model.addAttribute("Hotellist",hotel);
	    return "AdminHotelDetails"; 
		
	}
	
	@RequestMapping(value="/adminhotelSearch",method=RequestMethod.POST)
	public String adminHotelSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Hotel> hotel=hotelservice.findAll();
			model.addAttribute("Hotellist",hotel);
				return "AdminHotelDetails"; 
			
		}
		else {
			model.addAttribute("hotel_keyword",searchkey);
			List<Hotel> hotel=hotelservice.findBykey(searchkey);
			model.addAttribute("Hotellist",hotel);
			return "AdminHotelDetails"; 
			
		}
	}
	//Hotel Table Delete
	@RequestMapping(value="/admindeletehotel/{id}")
	public String admindeleteHotel(@PathVariable int id)
	{
		Hotel hotel=hotelservice.findById(id);
		System.out.println(hotel);
		if(hotel.getHotelName()!=null) {
			hotelservice.deleteHotel(id);
			return "redirect:/adminhoteldetails";
		}
		return "redirect:/adminhoteldetails";
	}
	
	//Add Hotel 
	@RequestMapping(value="/addhotelForm")
	public String savehotel(@RequestParam("subadmin") String role1,@RequestParam("superadmin") String role2,@RequestParam("hotelName") String hotelname,@RequestParam("hotelDesc") String hotelDesc,@RequestParam("location") String hotelLoc,@RequestParam("price") int hotelPrice,@RequestParam("hotelImg1") MultipartFile file) {
		hotelservice.savehoteltoDB(file, hotelname, hotelDesc, hotelLoc, hotelPrice);
		
		if(role1.equals("subadmin")&& role2.equals("not"))
		{
			return "redirect:/subadminhoteldetails";
		}
		else if(role1.equals("not")&& role2.equals("superadmin"))
		{
			return "redirect:/superadminhoteldetails";
		}
		else {
			return "redirect:/adminhoteldetails";
			}
	}
	
	//Hotel find
	@RequestMapping(value="hotelfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> adminhoteEditDetails(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Hotel>(hotelservice.findById(id),HttpStatus.OK);
		}
	    catch(Exception e) {
	    	return new ResponseEntity<Hotel>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	//Edit hotel
	@RequestMapping(value="/EdithotelForm",method=RequestMethod.POST)
	public String updateHotel(@RequestParam("subadmin") String role1,@RequestParam("superadmin") String role2,@RequestParam("hotelName") String hotelname,@RequestParam("hotelDesc") String hotelDesc,@RequestParam("location") String hotelLoc,@RequestParam("price") int hotelPrice,@RequestParam("hotelImg1") MultipartFile file ,@RequestParam("id") int id)  {
		
		if(file.isEmpty())
		{
			hotelservice.updateHotelDetails(hotelname,hotelDesc,hotelLoc,hotelPrice,id);
		}
		else 
		{
			hotelservice.updateHotelDetailswithImage(hotelname,hotelDesc,hotelLoc,hotelPrice,file,id);
		}
		if(role1.equals("subadmin")&& role2.equals("not"))
		{
			return "redirect:/subadminhoteldetails";
		}
		else if(role1.equals("not")&& role2.equals("superadmin"))
		{
			return "redirect:/superadminhoteldetails";
		}
		else 
		{
			return "redirect:/adminhoteldetails";
		}
		
	}
	
	
	
	//Catering Table
	@RequestMapping(value="/admincateringdetails",method=RequestMethod.GET)
	public String adminCateringDetails(Model model) {
		List<Catering> cater= caterservice.findAll();
		model.addAttribute("caterlist", cater);
	    return "AdminCateringDetails"; 
	}
	
	@RequestMapping(value="/admincateringSearch",method=RequestMethod.POST)
	public String admincaterSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Catering> cater= caterservice.findAll();
			model.addAttribute("caterlist", cater); 
		    
				return "AdminCateringDetails"; 
			
		}
		else {
			model.addAttribute("catering_keyword",searchkey);
			List<Catering> cater= caterservice.findBykey(searchkey);
			model.addAttribute("caterlist", cater);
			
				return "AdminCateringDetails"; 
			
		}
	}
	
	//Delete Catering
	@RequestMapping(value="/admindeletecater/{id}")
	public String admindeleteCater(@PathVariable int id)
	{
		Catering c=caterservice.findById(id);
		if(c.getCatername()!=null) {
			caterservice.deletecater(id);
			return "redirect:/admincateringdetails";
		}
		return "redirect:/admincateringdetails";
	}
	
	
	//Add Catering
	@RequestMapping(value="/addcaterForm")
	public String saveCater(@RequestParam("subadmin") String role1,@RequestParam("superadmin") String role2,@RequestParam("catername") String catername,@RequestParam("cater_desc") String caterDesc,@RequestParam("cater_location") String caterLoc,@RequestParam("cater_price") int caterprice,@RequestParam("cater_img") MultipartFile file) {
		caterservice.savecatertoDB(file, catername, caterDesc, caterLoc, caterprice);
		if(role1.equals("subadmin")&& role2.equals("not"))
		{
			return "redirect:/subadmincateringdetails";
		}
		else if(role1.equals("not")&& role2.equals("superadmin"))
		{
			return "redirect:/superadmincateringdetails";
		}
		else {
			return "redirect:/admincateringdetails";

			
		}
	}
	
	@RequestMapping(value="caterfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Catering> admincaterEditDetails(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Catering>(caterservice.findById(id),HttpStatus.OK);
		}
	    catch(Exception e) {
	    	return new ResponseEntity<Catering>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	@RequestMapping(value="/EditcaterForm",method=RequestMethod.POST)
	public String updateCater(@RequestParam("subadmin") String role1,@RequestParam("superadmin") String role2,@RequestParam("catername") String catername,@RequestParam("cater_desc") String caterdesc,@RequestParam("cater_location") String caterloc,@RequestParam("cater_price") int caterprice,@RequestParam("cater_img") MultipartFile file ,@RequestParam("id") int id)  {
		
		if(file.isEmpty())
		{
			caterservice.updateCaterDetails(catername,caterdesc,caterloc,caterprice,id);
		}
		else {
			caterservice.updateCaterDetailswithImage(catername,caterdesc,caterloc,caterprice,file,id);
		}
		if(role1.equals("subadmin")&& role2.equals("not"))
		{
			return "redirect:/subadmincateringdetails";
		}
		else if(role1.equals("not")&& role2.equals("superadmin"))
		{
			return "redirect:/superadmincateringdetails";
		}
		else {
			return "redirect:/admincateringdetails";

			
		}
	}
	
	//Vendor Table
	@RequestMapping(value="/adminvendordetails",method=RequestMethod.GET)
	public String adminVendorDetails(ModelMap model) {
		List<Vendor> vendor=vendorservice.findAll();
		model.addAttribute("vendorlist",vendor);
	    return "AdminVendorDetails";  
	}
	
	@RequestMapping(value="/adminvendorSearch",method=RequestMethod.POST)
	public String adminvendorSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		System.out.println(searchkey);
		if(searchkey.equals("")) {
			List<Vendor> vendor=vendorservice.findAll();
			model.addAttribute("vendorlist",vendor);
			
				return "AdminVendorDetails"; 
			 
		}
		else {
			model.addAttribute("vendor_keyword",searchkey);
			List<Vendor> vendor=vendorservice.findBykey(searchkey);
			model.addAttribute("vendorlist",vendor);
			
				return "AdminVendorDetails"; 
			
		}
	}
	
	
	//Delete Vendor
	@RequestMapping(value="/admindeletevendor/{id}")
	public String admindeleteVendor(@PathVariable int id ) {
		Vendor v =vendorservice.findById(id);
		System.out.println(v);
		vendorservice.deletevendor(id);
		return "redirect:/adminvendordetails";
	}
	
	//Add Vendor
	@RequestMapping(value="/addvendorForm")
	public String saveVendor(@RequestParam("subadmin") String role1 ,@RequestParam("superadmin") String role2,@RequestParam("vendorname") String vendorname,@RequestParam("vendor_desc") String vendorDesc,@RequestParam("vendor_location") String vendorLoc,@RequestParam("vendor_price") int vendorprice,@RequestParam("vendor_img") MultipartFile file) {
		vendorservice.savevendortodb(file, vendorname,vendorDesc,vendorLoc,vendorprice);
		if(role1.equals("subadmin")&& role2.equals("not"))
		{
			return "redirect:/subadminvendordetails";
		}
		else if(role1.equals("not")&& role2.equals("superadmin"))
		{
			return "redirect:/superadminvendordetails";
		}
		else {
			return "redirect:/adminvendordetails";
		}
		
	}
	
	@RequestMapping(value="vendorfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vendor> adminvendorEditDetails(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Vendor>(vendorservice.findById(id),HttpStatus.OK);
		}
	    catch(Exception e) {
	    	return new ResponseEntity<Vendor>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	@RequestMapping(value="/EditvendorForm",method=RequestMethod.POST)
	public String updatevendor(@RequestParam("subadmin") String role1,@RequestParam("superadmin") String role2,@RequestParam("vendorname") String vendorname,@RequestParam("vendor_desc") String vendordesc,@RequestParam("vendor_location") String vendorloc,@RequestParam("vendor_price") int vendorprice,@RequestParam("vendor_img") MultipartFile file ,@RequestParam("id") int id)  {
		if(file.isEmpty())
		{
			vendorservice.updatevendorDetails(vendorname,vendordesc,vendorloc,vendorprice,id);
		}
		else {
			vendorservice.updateVendorDetailswithImage(vendorname,vendordesc,vendorloc,vendorprice,file,id);
		}
		
		if(role1.equals("subadmin")&& role2.equals("not"))
		{
			return "redirect:/subadminvendordetails";
		}
		else if(role1.equals("not")&& role2.equals("superadmin"))
		{
			return "redirect:/superadminvendordetails";
		}
		else {
			return "redirect:/adminvendordetails";

			
		}
		
	}

	
	
	
	//Booking details
	@RequestMapping(value="/adminbookingdetails",method=RequestMethod.GET)
	public String adminBookingDetails(ModelMap model) {
		List<Booking> booking=bookingservice.findAll();
		model.addAttribute("admin_booking",booking);
	    return "AdminBookingDetails";  
	}

	//Admin Account
	@RequestMapping(value="/adminaccount",method=RequestMethod.GET)
	public String adminAccount(HttpSession session) {
		System.out.println(session.getAttribute("Admin_email"));
	    return "AdminAccount";  
	}
	
	@RequestMapping(value="/editadminprofile",method=RequestMethod.POST)
	public String updateAdminProfile(@ModelAttribute("adminEditProfile") User admin ,HttpSession session) {
		System.out.println(admin);
		
		userservice.updateUserProfile(admin.getEmail(),admin.getFirstName(),admin.getLastName(),admin.getGender(),admin.getContactno(),admin.getAddress(),admin.getRole(),admin.getPassword(),admin.getConfirmPassword(),admin.getId());
		session.setAttribute("Admin_firstname",admin.getFirstName());
		session.setAttribute("Admin_lastname", admin.getLastName());
		session.setAttribute("Admin_email", admin.getEmail());
		session.setAttribute("Admin_phone", admin.getContactno());
		session.setAttribute("Admin_address", admin.getAddress());
		session.setAttribute("Admin_gender", admin.getGender());
		session.setAttribute("Admin_id", admin.getId());
		session.setAttribute("Admin_role", admin.getRole());
		session.setAttribute("Admin_cpassword", admin.getConfirmPassword());
		session.setAttribute("Admin_password", admin.getPassword());
	
	
		return "redirect:/adminaccount";
		
	}
	
	
	//Event Table
		@RequestMapping(value="/admineventdetails",method=RequestMethod.GET)
		public String adminEventDetails(ModelMap model) {
			List<Event> event=eventservice.findAll();
			model.addAttribute("eventlist",event);
		    return "AdminEventDetails"; 
			
		}
		
		@RequestMapping(value="/admineventSearch",method=RequestMethod.POST)
		public String adminEventSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
			
			System.out.println(searchkey);
			if(searchkey.equals("")) {
				List<Event> event=eventservice.findAll();
				model.addAttribute("eventlist",event);
				
					return "AdminEventDetails"; 
				
			      
			}
			else {
				model.addAttribute("event_keyword",searchkey);
				List<Event> event=eventservice.findBykey(searchkey);
				model.addAttribute("eventlist",event);
				
					return "AdminEventDetails"; 
				
			    
			}
		}
		
		@RequestMapping(value="/admindeleteevent/{id}")
		public String admindeleteEvent(@PathVariable int id ) {
			Event v =eventservice.findById(id);
			System.out.println(v);
			eventservice.deleteevent(id);
			return "redirect:/admineventdetails";
		}
		
		
	//Add event
	@RequestMapping(value="/addeventForm")
	public String saveevent(@RequestParam("subadmin") String role1,@RequestParam("superadmin") String role2,@RequestParam("eventname") String eventname,@RequestParam("event_desc") String eventDesc,@RequestParam("event_img") MultipartFile file) {
		eventservice.saveeventtoDB(file, eventname,eventDesc);
			if(role1.equals("subadmin")&& role2.equals("not"))
			{
				return "redirect:/subadmineventdetails";
			}
			else if(role1.equals("not")&& role2.equals("superadmin"))
			{
				return "redirect:/superadmineventdetails";
			}
			else 
			{
				return "redirect:/admineventdetails";
			}
			
	}
		@RequestMapping(value="eventfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
		public ResponseEntity<Event> admineventEditDetails(@PathVariable("id") int id) {
			try {
				return new ResponseEntity<Event>(eventservice.findById(id),HttpStatus.OK);
			}
		    catch(Exception e) {
		    	return new ResponseEntity<Event>(HttpStatus.BAD_REQUEST);
		    }
			
		}
		
		@RequestMapping(value="/EditeventForm",method=RequestMethod.POST)
		public String updateevent(@RequestParam("subadmin") String role1,@RequestParam("superadmin") String role2,@RequestParam("eventname") String eventname,@RequestParam("event_desc") String eventdesc,@RequestParam("event_img") MultipartFile file ,@RequestParam("id") int id)  {
			
			if(file.isEmpty())
			{
				eventservice.updateeventDetails(eventname,eventdesc,id);
			}
			else {
				eventservice.updateeventDetailswithImage(eventname,eventdesc,file,id);
			}
			if(role1.equals("subadmin")&& role2.equals("not"))
			{
				return "redirect:/subadmineventdetails";
			}
			else if(role1.equals("not")&& role2.equals("superadmin"))
			{
				return "redirect:/superadmineventdetails";
			}
			else {
				return "redirect:/admineventdetails";
	
				
			}
			
		}
		
		
		
		@RequestMapping(value="/bookcancelbyadmin",method= RequestMethod.POST)
		public String UserBookingCancelAdmin(@RequestParam("booking_id") int booking_id)
		{
				bookingservice.bookingcancelByAdmin(booking_id);
				return "redirect:/adminbookingdetails";
		
		}
		
		
		@RequestMapping(value="/bookacceptbyadmin",method= RequestMethod.POST)
		public String UserBookingAcceptAdmin(@RequestParam("booking_id") int booking_id)
		{
				bookingservice.bookingacceptByAdmin(booking_id);
				return "redirect:/adminbookingdetails";
		
		}
		
		
		 @GetMapping("/downloadExcel")
		    public void exportToExcel(HttpServletResponse response) throws IOException {
		        response.setContentType("application/octet-stream");
		        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		        String currentDateTime = dateFormatter.format(new Date());
		         
		        String headerKey = "Content-Disposition";
		        String headerValue = "attachment; filename=BookingDetails_" + currentDateTime + ".xlsx";
		        response.setHeader(headerKey, headerValue);
		         
		        List<Booking> bookings =bookingservice.findAllandSortBy();
		         
//		        System.out.println(listUsers);
		        UserExcelExporter excelExporter = new UserExcelExporter(bookings);
		         
		        excelExporter.export(response);    
		    }  
		 
		 
		 @RequestMapping(value="/adminlogout",method=RequestMethod.GET)
			public String adminlogout(HttpSession session) {
			    if (session != null) {
			        // session.removeAttribute(null)
			        session.removeAttribute("Admin_firstname");
					session.removeAttribute("Admin_lastname");
					session.removeAttribute("Admin_email");
					session.removeAttribute("Admin_phone");
					session.removeAttribute("Admin_address");
					session.removeAttribute("Admin_gender");
					session.removeAttribute("Admin_id");
					session.removeAttribute("Admin_cpassword");
					session.removeAttribute("Admin_password");
					session.removeAttribute("Admin_role");
			    }
			    return "redirect:/signin"; 
			}

}
