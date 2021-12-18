package com.app.demo.controller;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.demo.model.PaytmDetails;
import com.app.demo.model.User;
import com.app.demo.services.BookingServices;
import com.app.demo.services.UserServices;
import com.paytm.pg.merchant.PaytmChecksum;


@Controller
public class PaymentController {
	
	@Autowired
	private PaytmDetails paytmDetails;
	@Autowired
	private Environment env;

	@Autowired
	private BookingServices bookingservice;
	
	@Autowired
	private UserServices userservice;
	
	private int booking_id;
	private int u_id;
	@RequestMapping(value="/paytmuser")
	public String paytm(@RequestParam(name="booking_id") int bookingId,@RequestParam(name="booking_userid") int u_id,@RequestParam(name="total_amt") long amt,ModelMap model,HttpSession session) {
			
		this.booking_id=bookingId;
		this.u_id=u_id;
		model.addAttribute("order_id",bookingId);
		model.addAttribute("user_id",u_id);
		
		
		model.addAttribute("amt",amt);
		
		return "paytmuser";
	}
	 @PostMapping(value = "/pgredirect")
	    public ModelAndView getRedirect(@RequestParam(name = "CUST_ID") String customerId,
	                                    @RequestParam(name = "TXN_AMOUNT") String transactionAmount,
	                                    @RequestParam(name = "ORDER_ID") String orderId) throws Exception {

	        ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetails.getPaytmUrl());
	        TreeMap<String, String> parameters = new TreeMap<>();
	        paytmDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
	        parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
	        parameters.put("EMAIL", env.getProperty("paytm.email"));
	        parameters.put("ORDER_ID", orderId);
	        parameters.put("TXN_AMOUNT", transactionAmount);
	        parameters.put("CUST_ID", customerId);
	        String checkSum = getCheckSum(parameters);
	        parameters.put("CHECKSUMHASH", checkSum);
	        modelAndView.addAllObjects(parameters);
	        return modelAndView;
	    }
	 
	 
	    @PostMapping(value = "/pgresponse")
	    public String getResponseRedirect(HttpServletRequest request, Model model,HttpSession session) {
	    	
	    	Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        mapData.forEach((key, val) -> parameters.put(key, val[0]));
	        String paytmChecksum = "";
	        if (mapData.containsKey("CHECKSUMHASH")) {
	            paytmChecksum = mapData.get("CHECKSUMHASH")[0];
	        }
	        
	        String result;

//	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        try {
	        	
	        	User userDetail=userservice.findById(u_id);
	    		
	    		session.setAttribute("User_firstname",userDetail.getFirstName());
	    		session.setAttribute("User_lastname", userDetail.getLastName());
	    		session.setAttribute("User_email", userDetail.getEmail());
	    		session.setAttribute("User_phone", userDetail.getContactno());
	    		session.setAttribute("User_address", userDetail.getAddress());
	    		session.setAttribute("User_gender", userDetail.getGender());
	    		session.setAttribute("User_id", userDetail.getId());
	    		session.setAttribute("User_cpassword", userDetail.getConfirmPassword());
	    		session.setAttribute("User_password", userDetail.getPassword());
	    		session.setAttribute("User_role", userDetail.getRole());
	    		
//	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);        
	            if (parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                	 bookingservice.bookingPayment(booking_id);
	         	         return "Paymentsuccess";
	                } else {
	                	 return "Paymentfail";
	                }
	            } else {
	                result = "Checksum mismatched";
	                return "Paymentfail";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	        parameters.remove("CHECKSUMHASH");
			return "redirect:/userbookingdetails";
	    }

	    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
	        return PaytmChecksum.verifySignature(parameters,
	                paytmDetails.getMerchantKey(), paytmChecksum);
	    }


	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return PaytmChecksum.generateSignature(parameters, paytmDetails.getMerchantKey());
	}
				
	}
	