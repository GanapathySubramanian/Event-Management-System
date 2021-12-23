package com.app.demo;

import java.awt.Color;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletResponse;

import com.app.demo.model.Booking;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;

import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

 
public class UserPDFExporter {
 
	private Booking booking;

	public UserPDFExporter(Booking booking) {
		// TODO Auto-generated constructor stub
		
		this.booking=booking;
		
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
        
        Paragraph title = new Paragraph("EXQUISITE BILL", titlefont);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
       
        
        document.add(new Paragraph("Booking id : "+booking.getId(), parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Name : "+booking.getUser().getFirstName()+" "+booking.getUser().getLastName(), parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Email : "+booking.getUser().getEmail(), parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Phone Number : "+booking.getUser().getContactno(), parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Address : "+booking.getUser().getAddress(), parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Gender : "+booking.getUser().getGender(), parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Event :  "+booking.getEvent().getEventname(), parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Hotel Name : "+booking.getHotel().getHotelName(), parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Hotel Location : "+booking.getHotel().getLocation(), parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Catering Name : "+booking.getCatering().getCatername(), parafont));
       
        document.add(new Paragraph(" ", parafont));
                
        document.add(new Paragraph("Catering Location : "+booking.getCatering().getCater_location(), parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Decorator: "+booking.getDecorator_name_desc(), parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Photographer: "+booking.getPhotographer_name_desc(), parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Disc Jockey: "+booking.getDj_name_desc() ,parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Makeupartist : "+booking.getMakeupartist_name_desc(),parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Booked on : "+booking.getCurrent_date(), parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Event Date: "+booking.getEvent_date(), parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Hotel  Price : Rs."+booking.getHotel().getPrice()+" per hour", parafont));
       
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Event max time : "+ booking.getMax_total_hour()+" hours", parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Catering Price : Rs."+booking.getCatering().getCater_price()+" per person", parafont));
        
        document.add(new Paragraph(" ", parafont));
        
        document.add(new Paragraph("Number of guest : "+booking.getNo_of_guest(), parafont));
        
        document.add(new Paragraph(" ", parafont));

        
        document.add(new Paragraph("Total Price : Rs."+booking.getAmount(), parafont));
        
        Font endfont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        endfont.setSize(20);
        endfont.setColor(Color.PINK);
        Paragraph end = new Paragraph("Enjoy your  "+booking.getEvent().getEventname()+" Event", endfont);
        end.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(end);
        document.close();

        
         
    }
}
