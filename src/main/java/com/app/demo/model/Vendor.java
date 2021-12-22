package com.app.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CollectionId;

@Entity(name="vendor")
public class Vendor {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	@Column(name="vendorname")
	private String vendorname;
	
	@Column(name="vendor_desc")
	private String vendor_desc;
	
	@Column(name="vendor_location")
	private String vendor_location;
	
	@Column(name="vendor_price")
	private int vendor_price;
	
	@Column(name="vendor_img",columnDefinition = "longblob")
	private String vendor_img;

	public String getVendor_img() {
		return vendor_img;
	}

	public void setVendor_img(String vendor_img) {
		this.vendor_img = vendor_img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getVendor_desc() {
		return vendor_desc;
	}

	public void setVendor_desc(String vendor_desc) {
		this.vendor_desc = vendor_desc;
	}

	public String getVendor_location() {
		return vendor_location;
	}

	public void setVendor_location(String vendor_location) {
		this.vendor_location = vendor_location;
	}

	public int getVendor_price() {
		return vendor_price;
	}

	public void setVendor_price(int vendorprice) {
		this.vendor_price = vendorprice;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", vendorname=" + vendorname + ", vendor_desc=" + vendor_desc + ", vendor_location="
				+ vendor_location + ", vendor_price=" + vendor_price + ", vendor_img=" + vendor_img + "]";
	}
	

}
