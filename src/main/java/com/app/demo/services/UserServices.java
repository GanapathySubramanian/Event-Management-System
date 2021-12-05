package com.app.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.User;
import com.app.demo.repository.UserRepo;

@Service
public class UserServices {
	
	@Autowired
	private UserRepo userrepo;

	public UserRepo getUserrepo() {
		return userrepo;
	}

	public void setUserrepo(UserRepo userrepo) {
		this.userrepo = userrepo;
	}
	
	public void save(User user) {
		
		System.out.println("saving...");
		userrepo.save(user);
	}
	
	public User findByEmail(String email) {
		User user=userrepo.findByEmail(email);
		
		return user;
	}
	
}
