package com.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.model.Event;

public interface EventRepo extends  JpaRepository<Event, Integer> {
	@Modifying
	@Transactional
	@Query("Update event set eventname=?1,event_desc=?2 where id=?3 ")
	public void updateevent(String eventname,String eventdesc,int id);

	@Modifying
	@Transactional
	@Query("Update event set eventname=?1,event_desc=?2, event_img=?3 where id=?4 ")
	public void updateeventwithImage(String eventName, String eventDesc, String image, int id);

	@Query("select e from event e where event_name LIKE %?1%")
	public List<Event> findbykey(String searchkey);

}
