package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
//	@Autowired
//	private iCoach myCoach;
//	
//	@Autowired
//	public DemoController(iCoach coach) {
//		this.myCoach = coach;
//	}
//	
//	@Autowired
//	public void setCoach(iCoach coach) {
//		myCoach = coach;
//	}
	
//	----------------------------------------
	
//	@Autowired
//	@Qualifier("galliDandaCoach")
	private iCoach myCoach;
	
//	public DemoController(@Qualifier("chessCoach")iCoach coach) {
//		this.myCoach = coach;
//	}
	
	@Autowired
	public void setCoach(@Qualifier("galliDandaCoach")iCoach coach) {
		this.myCoach = coach;
	}
	
	@GetMapping("/dailyWorkout")
	public String workOutDetails() {
		setCoach(myCoach);
		return myCoach.getDailyWorkout();
	}
}
