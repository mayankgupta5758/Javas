package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Rating;

public interface RatingService {

	Rating create(Rating rating);

	//get all ratings
	List<Rating> getRatings();

	//get all by UserId
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
}
