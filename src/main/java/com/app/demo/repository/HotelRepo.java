package com.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.model.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer>{
	
		@Modifying
		@Transactional
		@Query("Update hotel set hotel_name=?1,hotel_desc=?2,location=?3,price=?4 where id=?5 ")
		public void updateHotel(String hotelname,String hoteldesc, String location,int price,int id);

		@Modifying
		@Transactional
		@Query("Update hotel set hotel_name=?1,hotel_desc=?2,location=?3, price=?4, hotel_img1=?5 where id=?6 ")
		public void updateHotelwithImage(String hotelName, String hotelDesc, String location, int price, String image, int id);

		@Query("select h from hotel h where hotel_name LIKE %?1% or price LIKE %?1% or location LIKE %?1%")
		public List<Hotel> findbykey(String searchkey);

}
