package com.mayank.example;

//public class World extends Thread {
//	or
public class World implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 11; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
