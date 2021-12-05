package com.app.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
public class User {
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private int id;		
		@Id
		@Column(name="email")
		private String email;
		
		@Column(name="first_name")
		private String FirstName;
		
		@Column(name="last_name")
		private String LastName;
		
		@Column(name="Address")
		private String Address;
		
		@Column(name="contact_no")
		private String contactno;
		
		@Column(name="gender")
		private String Gender;
		
		@Column(name="password")
		private String Password;
		
		@Column(name="confirm_password")
		private String ConfirmPassword;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return FirstName;
		}
		public void setFirstName(String firstName) {
			FirstName = firstName;
		}
		public String getLastName() {
			return LastName;
		}
		public void setLastName(String lastName) {
			LastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public String getGender() {
			return Gender;
		}
		public void setGender(String gender) {
			Gender = gender;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getConfirmPassword() {
			return ConfirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			ConfirmPassword = confirmPassword;
		}
		
		public String getContactno() {
			return contactno;
		}
		public void setContactno(String contactno) {
			this.contactno = contactno;
		}
		@Override
		public String toString() {
			return "User [Id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", email=" + email
					+ ", Address=" + Address + ", Gender=" + Gender + ", contactno=" + contactno + ", Password="
					+ Password + ", ConfirmPassword=" + ConfirmPassword + "]";
		}
		
}
