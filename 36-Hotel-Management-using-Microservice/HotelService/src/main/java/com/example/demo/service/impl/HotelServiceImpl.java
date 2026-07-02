package com.example.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositary.HotelRepositary;
import com.example.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepositary hotelRepositary;

	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomId = UUID.randomUUID().toString();
		hotel.setHotelId(randomId);
		return hotelRepositary.save(hotel);
	}

	@Override
	public Hotel getById(String hotelId) {
		// TODO Auto-generated method stub
		return hotelRepositary.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel not found with thi id:" + hotelId));
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelRepositary.findAll();
	}

}
