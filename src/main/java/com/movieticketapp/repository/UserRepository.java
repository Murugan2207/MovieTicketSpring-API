package com.movieticketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieticketapp.model.User;

public interface UserRepository extends JpaRepository <User,Integer>{
	

}
