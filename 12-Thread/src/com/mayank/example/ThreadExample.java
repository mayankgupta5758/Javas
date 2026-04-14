package com.mayank.example;

public class ThreadExample {
	public static void main(String[] args) {
//	System.out.println("Hello World");
//	System.out.println(Thread.currentThread().getName());

//		. A new class World is created that extends Thread.
//		· The run method is overridden to define the code that constitutes the new thread.
//		· start method is called to initiate the new thread
		World world = new World(); // NEW
//		world.start(); // RUNNABLE

//		or 

//		. A new class World is created that implements Runnable.
//		· The run method is overridden to define the code that constitutes the new thread.
//		. A Thread object is created by passing an instance of MyRunnable.
//		· start method is called on the Thread object to initiate the new thread.

		Thread t1 = new Thread(world);
		t1.start(); // using implements esa run kerta hai.
//		t1.start();java.lang.IllegalThreadStateException runtime Exception.

		for (int i = 0; i < 11; i++) {
			System.out.println(Thread.currentThread().getName());
		}

		/*
		 * Jab koi or class kisi or class ko extend kar rahi ho to vo Thread ko extends
		 * nahi kar sekta to hum use implements hi kar payenga Runnable se
		 */
	}
}
