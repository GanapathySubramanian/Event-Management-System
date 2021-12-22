package com.app.demo.repository;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.model.User;


@Repository

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);
	
	public User findByResetPasswordToken(String token);
	
	@Modifying
	@Transactional
	@Query("Update user set email=?1,first_name=?2,last_name=?3,gender=?4,contact_no=?5,address=?6,role=?7 where Id=?8 ")
	public void updateUser(String email,String firstName,String lastName,String gender,String contactno,String address,String role,int id);

	@Modifying
	@Transactional
	@Query("Update user set email=?1,first_name=?2,last_name=?3,gender=?4,contact_no=?5,address=?6,role=?7 ,password=?8 ,confirm_password=?9 where Id=?10 ")
	public void updateUserpro(String email, String firstName, String lastName, String gender, String contactno,String address, String role, String password, String cpassword, int id);

	@Query("select u from user u where first_name LIKE %?1% or last_name LIKE %?1% or email LIKE %?1% or contact_no LIKE %?1% or gender LIKE %?1% or role LIKE %?1%")
	public List<User> findbykey(String searchkey);

	@Query("select u from user u where role=?1")
	public User findbyRole(String role);

	@Query("select count(u) from user u where role=?1")
	public long countByRole(String string);

}
