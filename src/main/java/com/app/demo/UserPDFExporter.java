package com.app.demo;

import java.awt.Color;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;

import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

 
public class UserPDFExporter {
 
   
	private int booking_id;
	private String user_email;
	private String first_name;
	private String last_name;
	private String user_phone;
	private String user_gender;
	private String user_address;
	private String hotel_name;
	private int hotel_price;
	private String cater_name;
	private int cater_price;
	private int total_price;
	private String booked_on;
	private String deco_name_desc;
	private String dj_name_desc;
	private String makeup_name_desc;
	private String photo_name_desc;
	private String event_name;
	private Date event_date;
	private String max_hour;
	private String no_guest;

	public UserPDFExporter(int id, String email, String firstName, String lastName, String contactno, String gender,
			String address, String hotelName, int hotelPrice, String caterName, int caterPrice, int total_amount,
			String booked_date, String decorator_name_desc, String dj_name_desc, String makeupartist_name_desc,
			String photographer_name_desc, String eventname, Date eventdate, String max_total_hour,
			String no_of_guest) {
		// TODO Auto-generated constructor stub
		this.booking_id=id;
		this.user_email=email;
		this.first_name=firstName;
		this.last_name=lastName;
		this.user_phone=contactno;
		this.user_gender=gender;
		this.user_address=address;
		this.hotel_name=hotelName;
		this.hotel_price=hotelPrice;
		this.cater_name=caterName;
		this.cater_price=caterPrice;
		this.total_price=total_amount;
		this.booked_on=booked_date;
		this.deco_name_desc=decorator_name_desc;
		this.dj_name_desc=dj_name_desc;
		this.makeup_name_desc=makeupartist_name_desc;
		this.photo_name_desc=photographer_name_desc;
		this.event_name=eventname;
		this.event_date=eventdate;
		this.max_hour=max_total_hour;
		this.no_guest=no_of_guest;
		
		
	}









	public void export(HttpServletResponse response) throws DocumentException, IOException {
       
		Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font titlefont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        titlefont.setSize(20);
        titlefont.setColor(Color.BLUE);
        
        Font parafont = FontFactory.getFont(FontFactory.HELVETICA);
        parafont.setSize(10);
        parafont.setColor(Color.BLACK);
        
        Paragraph title = new Paragraph("BILL", titlefont);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
       
        
        document.add(new Paragraph("Booking id : "+booking_id , parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Name : "+first_name+" "+last_name, parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Email : "+user_email, parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Phone Number : "+user_phone, parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Address : "+user_address, parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Gender : "+user_gender, parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Event :  "+event_name, parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Hotel Name : "+hotel_name, parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Catering Name : "+cater_name, parafont));
       
        document.add(new Paragraph(" ", parafont));
                
        document.add(new Paragraph("Decorator: "+deco_name_desc, parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Photographer: "+photo_name_desc, parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Disc Jockey: "+dj_name_desc ,parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Makeupartist : "+makeup_name_desc ,parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Booked on : "+booked_on, parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Event Date: "+event_date, parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Hotel  Price : Rs."+hotel_price+" per hour", parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Event max time : "+ max_hour+" hours", parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Catering Price : Rs."+cater_price+" per person", parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Number of guest : "+no_guest, parafont));
        
        document.add(new Paragraph(" ", parafont));

        
        document.add(new Paragraph("Total Price : Rs."+total_price, parafont));
        

        
        document.close();

        
         
    }
}