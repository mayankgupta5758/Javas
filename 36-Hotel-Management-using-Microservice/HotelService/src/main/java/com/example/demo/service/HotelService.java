package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	
	Hotel getById(String hotelId);
	
	List<Hotel> getAllHotel();
}
