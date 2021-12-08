package com.app.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Booking;
import com.app.demo.model.Catering;
import com.app.demo.model.User;
import com.app.demo.repository.BookingRepo;

@Service
public class BookingServices {
	
	@Autowired
	private BookingRepo bookingrepo;

	public BookingRepo getBookingrepo() {
		return bookingrepo;
	}

	public void setBookingrepo(BookingRepo bookingrepo) {
		this.bookingrepo = bookingrepo;
	}
	
	public void save(Booking booking) {
			
			System.out.println("saving...");
			bookingrepo.save(booking);
	}
	
	public Booking findById(int id) {
		return bookingrepo.findById(id).orElse(null);
		
	}
	



	public List<Booking> findAllByUser(User user) {
		// TODO Auto-generated method stub
		return bookingrepo.findAllByUser(user);
	}
}
