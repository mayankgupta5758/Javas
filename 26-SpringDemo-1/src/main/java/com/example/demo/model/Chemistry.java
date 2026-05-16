package com.example.demo.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Chemistry implements IScience {

	public Chemistry() {
		System.out.println("Chemistry Constructor.");
	}

	@PostConstruct
	public void init() {

		System.out.println(
			"Chemistry Bean Object Created.");
	}

	@PreDestroy
	public void destroy() {

		System.out.println(
			"Chemistry Bean Destroyed.");
	}

	@Override
	public String study() {
		return "Learning Chemistry.";
	}
}