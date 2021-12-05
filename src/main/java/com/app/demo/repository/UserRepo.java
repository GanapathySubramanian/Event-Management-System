package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.demo.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, String> {
  
}