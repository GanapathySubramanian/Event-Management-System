package com.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Booking;
import com.app.demo.model.User;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer>{

	

	@Query("select b.amount from bookings b where user_id=?1")
	public List<Booking> getAllbookinguser(int id);

	public List<Booking> findAllByUser(User user);

	

}
