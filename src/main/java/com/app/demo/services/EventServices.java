package com.app.demo.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.demo.model.Event;
import com.app.demo.model.User;
import com.app.demo.repository.EventRepo;
import com.app.demo.repository.EventRepo;

@Service
public class EventServices {

		@Autowired
		private EventRepo eventrepo;

		public EventRepo geteventrepo() {
			return eventrepo;
		}

		public void seteventrepo(EventRepo eventrepo) {
			this.eventrepo = eventrepo;
		}
		public void saveeventtoDB(MultipartFile eventimg1,String eventName,String eventdesc ) {
			
			Event e = new Event();
			
			
			
			e.setEventname(eventName);
			e.setEvent_desc(eventdesc);
			
			
			try {
				e.setEvent_img(Base64.getEncoder().encodeToString(eventimg1.getBytes()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			eventrepo.save(e);
		}
		
		public List<Event> findAll(){
			return eventrepo.findAll();
		}

		
		public Event findById(int id) {
			return eventrepo.findById(id).orElse(null);
		}
		public void deleteevent(int id)
		{
			System.out.println("deleting...");
			eventrepo.deleteById(id);
		}
		public void updateeventDetails(String eventname,String eventdesc,int id) {
			eventrepo.updateevent(eventname, eventdesc, id);
		}

		public void updateeventDetailswithImage(String eventName, String eventDesc, MultipartFile file,int id) {
			String image="";
			try {
				
				image= Base64.getEncoder().encodeToString(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eventrepo.updateeventwithImage(eventName, eventDesc,image, id);
			
		}

		public long eventCount() {
			// TODO Auto-generated method stub
			return eventrepo.count();
		}

		public List<Event> findBykey(String searchkey) {
			// TODO Auto-generated method stub
			return eventrepo.findbykey(searchkey);
		}
		
}