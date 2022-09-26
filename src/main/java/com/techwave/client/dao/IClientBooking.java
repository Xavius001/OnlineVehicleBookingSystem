package com.techwave.client.dao;

import java.util.List;

import com.techwave.client.model.CustomerBooking;
import com.techwave.client.model.Logindb;

public interface IClientBooking {
	
	List<CustomerBooking> getAllBookings(); //get
	
	CustomerBooking getByBookingId(String bookingId); //get
	
	String AddBooking(CustomerBooking cb); //post
	
	String UpdateBooking(CustomerBooking cb); //put
	
	String DeleteBooking(CustomerBooking cb); //delete
	
	String ApproveBooking(CustomerBooking cb, String bookingId);
	
	String RejectBooking(CustomerBooking cb, String bookingId);
}
