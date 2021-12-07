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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.demo.model.Catering;
import com.app.demo.model.Hotel;
import com.app.demo.model.User;
import com.app.demo.model.Vendor;
import com.app.demo.repository.CateringRepo;
import com.app.demo.repository.HotelRepo;
import com.app.demo.repository.VendorRepo;
import com.app.demo.services.CateringServices;
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
	private VendorRepo vendorrepo;
	
	@Autowired
	private CateringRepo caterrepo;
	
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
		@RequestMapping(value="find/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
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
	
	
	//Hotel Table Delete
	@RequestMapping(value="/admindeletehotel/{id}")
	public String admindeleteHotel(@PathVariable int id)
	{
		Optional<Hotel> h = hotelservice.findById(id);
		System.out.println(h);
		hotelservice.deleteHotel(id);
		return "redirect:/adminhoteldetails";
	}
	
	//Add Hotel 
	@RequestMapping(value="/addhotelForm")
	public String savehotel(@RequestParam("hotelName") String hotelname,@RequestParam("hotelDesc") String hotelDesc,@RequestParam("location") String hotelLoc,@RequestParam("price") int hotelPrice,@RequestParam("hotelImg1") MultipartFile file) {
		hotelservice.savehoteltoDB(file, hotelname, hotelDesc, hotelLoc, hotelPrice);
		return "redirect:/adminhoteldetails";
	}
	
	
	//Catering Table
	@RequestMapping(value="/admincateringdetails",method=RequestMethod.GET)
	public String adminCateringDetails(Model model) {
		List<Catering> cater= caterservice.findAll();
		model.addAttribute("caterlist", cater);
	    return "AdminCateringDetails"; 
	}
	
	//Delete Catering
	@RequestMapping(value="/admindeletecater/{catername}")
	public String admindeleteCater(@PathVariable String catername)
	{
		Catering c = caterservice.findByCatername(catername);
		System.out.println(c);
		caterrepo.deleteById(catername);
		return "redirect:/admincateringdetails";
	}
	
	//Add Catering
	@RequestMapping(value="/addcaterForm")
	public String saveCater(@RequestParam("catername") String catername,@RequestParam("cater_desc") String caterDesc,@RequestParam("cater_location") String caterLoc,@RequestParam("cater_price") int caterprice,@RequestParam("cater_img") MultipartFile file) {
		caterservice.savecatertoDB(file, catername, caterDesc, caterLoc, caterprice);
		return "redirect:/admincateringdetails";
	}
	
	
	//Vendor Table
	@RequestMapping(value="/adminvendordetails",method=RequestMethod.GET)
	public String adminVendorDetails(ModelMap model) {
		List<Vendor> vendor=vendorservice.findAll();
		model.addAttribute("vendorlist",vendor);
	    return "AdminVendorDetails";  
	}
	
	
	//Delete Vendor
	@RequestMapping(value="/admindeletevendor/{vendorname}")
	public String admindeleteVendor(@PathVariable String vendorname) {
		Vendor v = vendorservice.findByVendorname(vendorname);
		System.out.println(v);
		vendorrepo.deleteById(vendorname);
		return "redirect:/adminvendordetails";
	}
	
	//Add Vendor
	@RequestMapping(value="/addvendorForm")
	public String saveVendor(@RequestParam("vendorname") String vendorname,@RequestParam("vendor_desc") String vendorDesc,@RequestParam("vendor_location") String vendorLoc,@RequestParam("vendor_price") int vendorprice,@RequestParam("vendor_img") MultipartFile file) {
		vendorservice.savevendortodb(file, vendorname,vendorDesc,vendorLoc,vendorprice);
		return "redirect:/adminvendordetails";
		
	}
	
	
	@RequestMapping(value="/admineventdetails",method=RequestMethod.GET)
	public String adminEventDetails() {
	    return "AdminEventDetails";  
	}
	
	//Booking details
	@RequestMapping(value="/adminbookingdetails",method=RequestMethod.GET)
	public String adminBookingDetails() {
	    return "AdminBookingDetails";  
	}
	
	//Admin Account
	@RequestMapping(value="/adminaccount",method=RequestMethod.GET)
	public String adminAccount() {
	    return "AdminAccount";  
	}
}
