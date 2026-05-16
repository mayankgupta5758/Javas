package com.example.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Chemistry;

@Configuration
public class AppConfig {

	@Bean
	public Chemistry chemistry() {

		return new Chemistry();
	}
}