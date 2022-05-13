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

@Entity(name="movies")
public class Movies {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_id",nullable=false)
	private Integer id;
	@Column(name="movie_name",nullable=false )
	private  String movieName;
	@Column(name="ticket_price",nullable=false)
	private  Integer ticketPrice;
	@Column(name="ratings",nullable=false)
	private  Integer ratings;
	@Column(name="language",nullable=false)
	private String language;
	@Column(name="location",nullable=false)
	private String location;
	@Column(name="category",nullable=false)
	private String category;
	@Column(name="image",nullable=false)
	private String image;
}
