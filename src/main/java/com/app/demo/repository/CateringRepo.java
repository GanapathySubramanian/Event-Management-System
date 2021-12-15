package com.app.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.model.Catering;
import com.app.demo.model.Hotel;

@Repository
public interface  CateringRepo extends JpaRepository<Catering, Integer> {

	@Modifying
	@Transactional
	@Query("Update catering set catername=?1,cater_desc=?2,cater_location=?3,cater_price=?4 where id=?5 ")
	void updateCater(String catername, String caterdesc, String caterloc, int caterprice ,int id);
	
	@Modifying
	@Transactional
	@Query("Update catering set catername=?1,cater_desc=?2,cater_location=?3, cater_price=?4, cater_img=?5 where id=?6 ")
	public void updateCaterwithImage(String caterName, String caterDesc, String caterlocation, int caterprice, String image, int id);

	@Query("select c from catering c where catername LIKE %?1% or cater_price LIKE %?1% or cater_location LIKE %?1%")
	List<Catering> findbykey(String searchkey);



	
}
