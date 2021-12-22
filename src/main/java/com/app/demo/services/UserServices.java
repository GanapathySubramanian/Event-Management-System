package com.app.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.app.demo.UserNotFoundException;
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
	


	public List<User> findAll() {
//		if(keyword!=null) {
//			return userrepo.findAll(keyword);
//		}
		return userrepo.findAll();
	}
	

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		System.out.println("deleting....");
		userrepo.deleteById(id);
	}

	public User findById(int id) {
		return userrepo.findById(id).orElse(null);
	}
	
	
	public void updateUserDetails(String email,String firstName,String lastName,String gender,String contactno,String address,String role,int id) {
		userrepo.updateUser(email, firstName, lastName, gender, contactno, address, role, id);
		
	}
	public void updateUserProfile(String email,String firstName,String lastName,String gender,String contactno,String address,String role,String password,String cpassword,int id) {
		userrepo.updateUserpro(email, firstName, lastName, gender, contactno, address, role,password,cpassword ,id);
	}

	public long userCount() {
		// TODO Auto-generated method stub
		return userrepo.countByRole("User");
	}

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userrepo.findByEmail(email);
	}
	
	
	public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
		User user=userrepo.findByEmail(email);
		
		if(user!=null) {
				user.setResetPasswordToken(token);
				userrepo.save(user);
		}
		 else {
	            throw new UserNotFoundException("Could not find any customer with the email " + email);
	        }
	}
	
	
	
	 public User getByResetPasswordToken(String token) {
	        return userrepo.findByResetPasswordToken(token);
	    }
	     
	    public void updatePassword(User user, String newPassword) {
//	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	        String encodedPassword = passwordEncoder.encode(newPassword);
	        user.setPassword(newPassword);
	        user.setConfirmPassword(newPassword);
	        user.setResetPasswordToken(null);
	        userrepo.save(user);
	    }

		public List<User> findBykey(String searchkey) {
			// TODO Auto-generated method stub
			return userrepo.findbykey(searchkey);
		}

		public User findByRole(String role) {
			// TODO Auto-generated method stub
			return userrepo.findbyRole(role);
		}
	    
	
}
