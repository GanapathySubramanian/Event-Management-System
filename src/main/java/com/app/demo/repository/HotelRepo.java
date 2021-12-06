package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer>{

}
