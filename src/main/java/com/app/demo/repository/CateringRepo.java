package com.app.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Catering;
import com.app.demo.model.Hotel;

@Repository
public interface  CateringRepo extends JpaRepository<Catering, String> {
	public Catering findByCatername(String cater_name);



	
}
