package com.app.demo.services;

public interface TwillioService {

	public void sendSms(String to, String from, String body);
	
	
	public void makeCall(String from, String to);
	
	

}
