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


	@Query("select count(id) from bookings where payment_status=1 and accept_status=1")
	public long bookingcountPaid();

	
	@Query("select count(id) from bookings where accept_status=1 and payment_status=0")
	public long bookingcountunPaid();

	@Query("select count(id) from bookings where accept_status=0 and payment_status=0")
	public long allBookingPendingCount();

	
	@Query("select count(id) from bookings where accept_status=2 and payment_status=0")
	public long bookingcountcancelByAdmin();


	@Query("select count(id) from bookings where accept_status=3 and payment_status=0")
	public long bookingcountcancelByUser();

	@Query("select count(id) from bookings where user=?1")
	public long bookingcountByUser(User user);


	@Query("select count(id) from bookings where user_id=?1")
	public long bookingcountById(int id);


	@Query("select count(id) from bookings where user_id=?1 and payment_status=1 and accept_status=1")
	public long bookingcountPaidById(int id);


	@Query("select count(id) from bookings where user_id=?1 and accept_status=1 and payment_status=0")
	public long bookingcountunPaidById(int id);


	@Query("select count(id) from bookings where user_id=?1 and accept_status=2 and payment_status=0")
	public long bookingcountcancelByAdminById(int id);


	@Query("select count(id) from bookings where user_id=?1 and accept_status=3 and payment_status=0")
	public long bookingcountcancelByUserById(int id);


	@Query("select count(id) from bookings where user_id=?1 and accept_status=0 and payment_status=0")
	public long bookingpendingcountById(int id);

	@Query("Select b from bookings b where hotel_id=?1 and accept_status=1")
	public List<Booking> findHotelById(int id);

	@Query("Select b from bookings b where catering_id=?1 and accept_status=1")
	public List<Booking> findCateringById(int id);

	@Query("Select b from bookings b where photographer=?1 and accept_status=1")
	public List<Booking> findPhotoByNameId(String name_id);

	@Query("Select b from bookings b where dj=?1 and accept_status=1")
	public List<Booking> findDjByNameId(String name_id);


	@Query("Select b from bookings b where makeupartist=?1 and accept_status=1")
	public List<Booking> findMakeupByNameId(String name_id);

	@Query("Select b from bookings b where decorator=?1 and accept_status=1")
	public List<Booking> findDecoratorByNameId(String name_id);

	
//	@Query("select b from bookings b where b.user_id LIKE %?1%")
//	public List<Booking> findbykey(String searchkey);


}
