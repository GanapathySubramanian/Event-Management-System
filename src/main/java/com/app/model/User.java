package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name="user")
public class User {
	
		
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private int Id;
		private String FirstName;
		private String LastName;
		
		@Id
		private String email;
		private String Address;
		private String Gender;
		private String Password;
		private String ConfirmPassword;
		private String Role;
		
		
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
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
		public String getRole() {
			return Role;
		}
		public void setRole(String role) {
			Role = role;
		}
		@Override
		public String toString() {
			return "User [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", email=" + email
					+ ", Address=" + Address + ", Gender=" + Gender + ", Password=" + Password + ", ConfirmPassword="
					+ ConfirmPassword + ", Role=" + Role + "]";
		}
		
		
		
		
}
