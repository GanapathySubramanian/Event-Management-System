package com.app.demo.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.demo.model.Hotel;
import com.app.demo.repository.HotelRepo;

@Service
public class HotelServices {

		@Autowired
		private HotelRepo hotelrepo;

		public HotelRepo getHotelrepo() {
			return hotelrepo;
		}

		public void setHotelrepo(HotelRepo hotelrepo) {
			this.hotelrepo = hotelrepo;
		}
		public void savehoteltoDB(MultipartFile hotelimg1,String hotelName,String hoteldesc, String hotelloc, int hotelPrice ) {
			
			Hotel h = new Hotel();
			
			h.setHotelName(hotelName);
			h.setHotelDesc(hoteldesc);
			h.setLocation(hotelloc);
			h.setPrice(hotelPrice);
			
			try {
				h.setHotelImg1(Base64.getEncoder().encodeToString(hotelimg1.getBytes()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			hotelrepo.save(h);
		}
		
		public List<Hotel> findAll(){
			return hotelrepo.findAll();
		}

		
		public Optional<Hotel> findById(int id){
			Hotel hotel = new Hotel();
			Optional<Hotel> h = hotelrepo.findById(hotel.getId());
			return h;
		}
		public void deleteHotel(int id)
		{
			System.out.println("deleting...");
			hotelrepo.deleteById(id);
		}
}
