package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class GalliDandaCoach implements iCoach{

	@Override
	public String getDailyWorkout() {
		return "Just Need Danda and a Piece of Wood.";
	}

}
