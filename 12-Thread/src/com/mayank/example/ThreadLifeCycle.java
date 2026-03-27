package com.mayank.example;

public class ThreadLifeCycle extends Thread {
	@Override
	public void run() {
		System.out.println("RUNNING");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
//	ye enum me state hai ulta.
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getState());  // RUNNABLE
		ThreadLifeCycle t1 = new ThreadLifeCycle();
		System.out.println(t1.getState());  // NEW
		t1.start();
		System.out.println(t1.getState());  // RUNNABLE
		Thread.sleep(100); // compile time exception InterruptedException
		System.out.println(t1.getState());
		t1.join(); // wait for this thread to terminate.
		System.out.println(t1.getState());
	}
}
