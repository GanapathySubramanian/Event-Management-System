package com.app.demo.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.demo.model.Catering;
import com.app.demo.model.Hotel;
import com.app.demo.repository.CateringRepo;


@Service
public class CateringServices {

	@Autowired
	private CateringRepo  cateringrepo;
	
	

	public CateringRepo getCateringrepo() {
		return cateringrepo;
	}

	public void setCateringrepo(CateringRepo cateringrepo) {
		this.cateringrepo = cateringrepo;
	}
	
	public void save(Catering catering) {
		
		System.out.println("saving...");
		cateringrepo.save(catering);
	}
	
	

	public List<Catering> findAll() {
		
		return cateringrepo.findAll();
	}

	public void savecatertoDB(MultipartFile file, String catername, String caterDesc, String caterLoc, int caterprice) {
		Catering c = new Catering();
		
	c.setCatername(catername);
	c.setCater_desc(caterDesc);
	c.setCater_location(caterLoc);
	c.setCater_price(caterprice);
	
		
		try {
			c.setCater_img(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		cateringrepo.save(c);
		
	}

	
	public void deletecater(int id)
	{
		System.out.println("deleting...");
		cateringrepo.deleteById(id);
	}



	public Catering findById(int id) {
		return cateringrepo.findById(id).orElse(null);
		
	}

	

	public void updateCaterDetailswithImage(String catername, String caterdesc, String caterloc, int caterprice, MultipartFile file, int id) {
		String image="";
		try {
			
			image= Base64.getEncoder().encodeToString(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cateringrepo.updateCaterwithImage(catername, caterdesc,  caterloc, caterprice ,image, id);
		
		
	}

	public void updateCaterDetails(String catername, String caterdesc, String caterloc, int caterprice, int id) {
		cateringrepo.updateCater(catername, caterdesc, caterloc, caterprice, id);
	}

	public long cateringcount() {
		// TODO Auto-generated method stub
		return cateringrepo.count();
	}

	public List<Catering> findBykey(String searchkey) {
		// TODO Auto-generated method stub
		return cateringrepo.findbykey(searchkey);
	}

	
}