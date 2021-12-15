package com.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.model.Hotel;
import com.app.demo.model.Vendor;

@Repository
public interface  VendorRepo extends JpaRepository<Vendor, Integer> {

	
	@Modifying
	@Transactional
	@Query("Update vendor set vendorname=?1,vendor_desc=?2,vendor_location=?3,vendor_price=?4 where id=?5 ")
	void updatevendor(String vendorname, String vendordesc, String vendorloc, int vendorprice ,int id);
	
	@Modifying
	@Transactional
	@Query("Update vendor set vendorname=?1,vendor_desc=?2,vendor_location=?3, vendor_price=?4, vendor_img=?5 where id=?6 ")
	public void updatevendorwithImage(String vendorName, String vendorDesc, String vendorlocation, int vendorprice, String image, int id);

	@Query("select v from vendor v where vendorname LIKE %?1% or vendor_location LIKE %?1% or vendor_price LIKE %?1%")
	List<Vendor> findbykey(String searchkey);

}
