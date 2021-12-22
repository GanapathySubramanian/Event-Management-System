package com.app.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="catering")
public class Catering {
	

	@GeneratedValue( strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	@Column(name="catername")
	private String catername;
	
	@Column(name="cater_desc")
	private String cater_desc;
	
	@Column(name="cater_location")
	private String cater_location;
	
	@Column(name="cater_price")
	private int cater_price;
	
	@Column(name="cater_img",columnDefinition = "longblob")
	private String cater_img;

	@OneToMany(mappedBy="catering",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Booking> booking;
	
	public int getId() {
		return id;
	}

	public String getCater_img() {
		return cater_img;
	}

	public void setCater_img(String cater_img) {
		this.cater_img = cater_img;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatername() {
		return catername;
	}

	public void setCatername(String catername) {
		this.catername = catername;
	}

	public String getCater_desc() {
		return cater_desc;
	}

	public void setCater_desc(String cater_desc) {
		this.cater_desc = cater_desc;
	}

	public String getCater_location() {
		return cater_location;
	}

	public void setCater_location(String cater_location) {
		this.cater_location = cater_location;
	}

	public int getCater_price() {
		return cater_price;
	}

	public void setCater_price(int caterprice) {
		this.cater_price = caterprice;
	}
	
	@Override
	public String toString() {
		return "Catering [id=" + id + ", catername=" + catername + ", cater_desc=" + cater_desc + ", cater_location="
				+ cater_location + ", cater_price=" + cater_price + ", cater_img=" + cater_img + "]";
	}

}
