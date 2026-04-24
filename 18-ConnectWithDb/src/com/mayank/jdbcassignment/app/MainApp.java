package com.mayank.jdbcassignment.app;

import java.util.Scanner;

import com.mayank.jdbcassignment.service.StudentService;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentService service = new StudentService();
		service.start(scanner);
	}
}
