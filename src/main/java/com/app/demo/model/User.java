package com.app.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="user")
public class User {
	   
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;		
		
		@Column(name="email")
		private String email;
		
		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Column(name="Address",columnDefinition = "text")
		private String address;
		
		@Column(name="contact_no")
		private String contactno;
		
		@Column(name="gender")
		private String gender;
		
		@Column(name="password")
		private String password;
		
		@Column(name="confirm_password")
		private String confirmPassword;
		
		@Column(name="role")
		private String role;
		
		@Column(name="reset_password_token")
		private String resetPasswordToken;
		

		@OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
		private List<Booking> booking;
		
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getContactno() {
			return contactno;
		}

		public void setContactno(String contactno) {
			this.contactno = contactno;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		
		public String getResetPasswordToken() {
			return resetPasswordToken;
		}

		public void setResetPasswordToken(String resetPasswordToken) {
			this.resetPasswordToken = resetPasswordToken;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", address=" + address + ", contactno=" + contactno + ", gender=" + gender + ", password="
					+ password + ", confirmPassword=" + confirmPassword + ", role=" + role + "]";
		}
		
		
		
}