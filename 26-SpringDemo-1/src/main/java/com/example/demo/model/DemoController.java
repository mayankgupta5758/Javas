package com.example.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private IScience myScienceObj;
	private IScience mySecondScienceObj;

	public DemoController(@Qualifier("chemistry") IScience scienceObj, @Qualifier("chemistry") IScience secondScienceObj) {
		System.out.println("Inside Constructor: " + getClass().getSimpleName());
		this.myScienceObj = scienceObj;
		this.mySecondScienceObj = secondScienceObj;
	}

//	@Autowired
//	public void setScience(@Qualifier("zology") IScience iScience) {
//		scienceObj = iScience;
//	}

	@GetMapping("/check")
	public String check() {
		return "beans comparing: myScienceObj = mySecondScienceObj: " + (myScienceObj == mySecondScienceObj);
	}
	@GetMapping("/study")
	public String workOutDetails() {
		return myScienceObj.study();
	}
}
