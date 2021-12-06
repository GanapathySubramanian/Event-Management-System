package com.app.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mysql.cj.jdbc.Blob;

@Entity
@Table(name="hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
    
    @Column(name="hotel_name")
	private String hotelName;
    
    @Column(name="hotel_desc")
	private String hotelDesc;
    
    @Column(name="hotel_img1")
	private String hotelImg1;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelDesc() {
		return hotelDesc;
	}

	public void setHotelDesc(String hotelDesc) {
		this.hotelDesc = hotelDesc;
	}

	public String getHotelImg1() {
		return hotelImg1;
	}

	public void setHotelImg1(String hotelImg1) {
		this.hotelImg1 = hotelImg1;
	}

	@Override
	public String toString() {
		return "Hotel [Id=" + Id + ", hotelName=" + hotelName + ", hotelDesc=" + hotelDesc + ", hotelImg1=" + hotelImg1
				+ "]";
	}
    
    
    
}
