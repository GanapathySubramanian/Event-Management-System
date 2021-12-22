package com.app.demo.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity(name="event")
public class Event {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	@Column(name="event_name")
	private String eventname;
	
	@Column(name="event_desc")
	private String event_desc;
	
	@Column(name="event_img",columnDefinition = "longblob")
	private String event_img;

	
	@OneToMany(mappedBy="event",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Booking> booking;
	
	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEvent_desc() {
		return event_desc;
	}

	public void setEvent_desc(String event_desc) {
		this.event_desc = event_desc;
	}

	public String getEvent_img() {
		return event_img;
	}

	public void setEvent_img(String event_img) {
		this.event_img = event_img;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", eventname=" + eventname + ", event_desc=" + event_desc + ", event_img="
				+ event_img + "]";
	}
	

}
