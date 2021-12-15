package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.demo.services.BookingServices;
import com.app.demo.services.PaypalService;
import com.paypal.api.payments.Links;
import com.app.demo.model.Booking;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PaypalController {

	@Autowired
	PaypalService service;

	@Autowired
	BookingServices bookingservice;
	
	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	private int booking_id;

	@PostMapping("/pay")
	public String payment(@RequestParam("booking_userid") int userid,@RequestParam("total_amt") int amount,@RequestParam("booking_id") int bookingid) {
		
		this.booking_id=bookingid;
		
		try {
			Payment payment = service.createPayment(userid,amount,bookingid ,"http://localhost:8080/" + CANCEL_URL,
					"http://localhost:8080/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "redirect:/userbookingsdetails";
	}
	
	 @GetMapping(value = CANCEL_URL)
	    public String cancelPay() {
	        return "redirect:/userbookingdetails";
	    }

	    @GetMapping(value = SUCCESS_URL)
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
	        try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.toJSON());
	            if (payment.getState().equals("approved")) {
	            	bookingservice.bookingPayment(booking_id);
	    			return "redirect:/userbookingdetails";
	            }
	        } catch (PayPalRESTException e) {
	         System.out.println(e.getMessage());
	        }
	        return "redirect:/userbookingdetails";
	    }

}
