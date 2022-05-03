package com.movieticketapp.model;

import java.time.LocalDate;


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

@Entity(name = "movie_booking")

public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_id",nullable=false)
	private Integer bookingId;
	@Column(name="user_id",nullable=false)
	private Integer userId;
	@Column(name="movie_id",nullable=false)
	private Integer movieId;
	@Column(name="no_of_tickets",nullable=false)
	private Integer noOfTickets;
	@Column(name="total_amount",nullable=false)
	private Integer totalAmount;
	@Column(name="status",nullable=false)
	private String status;
	@Column(name="show_date",nullable=false)
	private LocalDate showDate;
	@Column(name="booking_date",nullable=false)
	private LocalDate bookingDate;

}
