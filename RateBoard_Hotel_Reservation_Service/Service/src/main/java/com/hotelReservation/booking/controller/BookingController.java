package com.hotelReservation.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelReservation.booking.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@GetMapping("/booking")
	public String getAndSaveBookingData(@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("bookingDate") String bookingDate) {
		Integer reservationId = bookingService.consumeHotelInformation(name, phoneNumber, bookingDate);
		//System.out.println("Hotel Booked successfully and the id is ::" + reservationId);
		return "Your reservation has confirmed!! have a nice trip.";
	}



}
