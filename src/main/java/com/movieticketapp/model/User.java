package com.movieticketapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity(name="user_register")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id",nullable=false)
    private Integer id;
	@Column(name="name",nullable=false)
	private String name;
	@Column(name="email",nullable=false)
	private String email;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="phone_no",nullable=false)
	private String phoneNo;

}
