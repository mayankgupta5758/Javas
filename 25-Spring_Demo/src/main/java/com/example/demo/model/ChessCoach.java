package com.example.demo.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
// mtlb ye by default ye hi lega obj.
public class ChessCoach implements iCoach{

	@Override
	public String getDailyWorkout() {
		return "Play For Fun :)";
	}

}
