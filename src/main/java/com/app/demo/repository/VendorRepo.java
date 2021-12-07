package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Hotel;
import com.app.demo.model.Vendor;

@Repository
public interface  VendorRepo extends JpaRepository<Vendor, String> {
	public Vendor findByVendorname(String vendor_name);
}
