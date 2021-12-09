package com.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.model.Booking;
import com.app.demo.model.User;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer>{

	public List<Booking> findAllByUser(User user);

	
	@Modifying
	@Transactional
	@Query("Update bookings set accept_status=3 where id=?1 ")
	public void bookcancelByUser(int id);



	@Modifying
	@Transactional
	@Query("Update bookings set accept_status=2 where id=?1 ")
	public void bookcancelByadmin(int booking_id);
	
	
	@Modifying
	@Transactional
	@Query("Update bookings set payment_status=1 where id=?1 ")
	public void bookingPaymentCompleted(int id);

	@Modifying
	@Transactional
	@Query("Update bookings set accept_status=1 where id=?1 ")
	public void bookacceptByadmin(int booking_id);


}
