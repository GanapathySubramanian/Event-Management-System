package com.app.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		public List<Hotel> findAll(){
			return hotelrepo.findAll();
		}
}
