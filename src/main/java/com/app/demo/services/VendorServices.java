package com.app.demo.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.app.demo.model.Vendor;

import com.app.demo.repository.VendorRepo;

@Service
public class VendorServices {

	@Autowired
	private VendorRepo  vendorrepo;
	
	

	public VendorRepo getVendorrepo() {
		return vendorrepo;
	}

	public void setVendorrepo(VendorRepo hotelrepo) {
		this.vendorrepo = hotelrepo;
	}
	
	public void save(Vendor vendor) {
		
		System.out.println("saving...");
		vendorrepo.save(vendor);
	}
	
	

	public List<Vendor> findAll() {
		
		return vendorrepo.findAll();
	}

	public void savevendortodb(MultipartFile file, String vendorname, String vendorDesc, String vendorLoc,
			int vendorprice) {
		Vendor v= new Vendor();
		v.setVendorname(vendorname);
		v.setVendor_desc(vendorDesc);
		v.setVendor_location(vendorLoc);
		v.setVendor_price(vendorprice);
		
			
			try {
				v.setVendor_img(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			vendorrepo.save(v);
		
	}
	public void deletevendor(int id)
	{
		System.out.println("deleting...");
		vendorrepo.deleteById(id);
	}

	public Vendor findById(int id) {
		return vendorrepo.findById(id).orElse(null);
	}
	
	public void updateVendorDetailswithImage(String vendorname, String vendordesc, String vendorloc, int vendorprice, MultipartFile file, int id) {
		String image="";
		try {
			
			image= Base64.getEncoder().encodeToString(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vendorrepo.updatevendorwithImage(vendorname, vendordesc,  vendorloc, vendorprice ,image, id);
		
		
		}
	public void updatevendorDetails(String vendorname, String vendordesc, String vendorloc, int vendorprice, int id) {
		vendorrepo.updatevendor(vendorname, vendordesc, vendorloc, vendorprice, id);
	}

	public long vendorcount() {
		// TODO Auto-generated method stub
		return vendorrepo.count();
	}

	public List<Vendor> findBykey(String searchkey) {
		// TODO Auto-generated method stub
		return vendorrepo.findbykey(searchkey);
	}


	
}
