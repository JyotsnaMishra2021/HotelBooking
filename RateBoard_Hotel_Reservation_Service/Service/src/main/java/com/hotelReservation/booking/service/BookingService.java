package com.hotelReservation.booking.service;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;


@Service
public class BookingService {
	@Async
	public Integer consumeHotelInformation(String name,String phonenumber,String date) {
		Integer reservationId = incrementedVale(1) ;
		
		
		//dummy logic to save hotel booking data 
		sleep(2);
		System.out.println("Booking for customer ::"+ name + "and reservation id is ::"+reservationId);
		
		//To check exception uncomment below line
		//System.out.println(10/0);
		return reservationId;
	}
	
	private Integer incrementedVale(int i) {
		
		return i++;
	}

	private void sleep(int arg) {
		try {
			TimeUnit.SECONDS.sleep(arg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
