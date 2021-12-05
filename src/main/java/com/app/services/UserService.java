package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.Repository.UserRepo;
import com.app.model.User;


@Service
public class UserService {
    
	@Autowired
    private UserRepo userRepository;
    
    
	public UserRepo getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepo userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public void save(User user)
	{
		userRepository.save(user);
		System.out.println("heelo");
	}


    
}

