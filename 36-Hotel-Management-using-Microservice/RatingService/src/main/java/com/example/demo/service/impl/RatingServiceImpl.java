package com.example.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Rating;
import com.example.demo.repositary.RatingRepositary;
import com.example.demo.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepositary ratingRepositary;

	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		String randomId = UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		return ratingRepositary.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return ratingRepositary.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepositary.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepositary.findByHotelId(hotelId);
	}

}
