package com.movieticketapp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketapp.model.Booking;

import com.movieticketapp.repository.BookingRepository;

@RestController
public class BookingController {
	@Autowired
	BookingRepository bookingRepository;

	@GetMapping("booking/save") // register
	public String save(@RequestParam("userId") Integer userId, @RequestParam("movieId") Integer movieId,
			@RequestParam("noOfTickets") Integer noOfTickets, @RequestParam("totalAmount") Integer totalAmount,
			 @RequestParam("showDate") String showDate) {
		Booking booking = new Booking();
		LocalDate date = LocalDate.now();
		LocalDate date1 = LocalDate.parse(showDate);
		booking.setUserId(userId);
		booking.setMovieId(movieId);
		booking.setNoOfTickets(noOfTickets);
		booking.setTotalAmount(totalAmount);
		booking.setShowDate(date1);
		booking.setBookingDate(date);
		String result = null;
		try {
			bookingRepository.save(booking);
			result = "success";
		} catch (Exception e) {
			e.getMessage();
			result = "failed";
		}
		return result;

	}

	@GetMapping("booking/find/{user_id}")
	public Booking findById(@PathVariable("user_id") Integer user_id) {
		Optional<Booking> booking = bookingRepository.findById(user_id);
		if (booking.isPresent()) {
			Booking bookingDetails = booking.get();
			return bookingDetails;
		} else {
			return null;
		}

	}

	@GetMapping("booking/list")
	public List<Booking> findAll() {
		List<Booking> bookinglist = bookingRepository.findAll();
		return bookinglist;
	}

	@PutMapping("booking/update/{booking_id}")
	public Booking update(@PathVariable("booking_id") Integer booking_id, @RequestBody Booking booking) {
		booking.setBookingId(booking_id);
		bookingRepository.save(booking);
		return booking;
	}
}
