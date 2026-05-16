package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements iCoach {

	@Override
	public String getDailyWorkout() {
		return "Just Do Sleeping :)";
	}
}