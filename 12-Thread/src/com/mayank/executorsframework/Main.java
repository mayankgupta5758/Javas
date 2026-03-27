package com.mayank.executorsframework;
//
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {

//// long startTime = System.currentTimeMillis(); // 1-1-1970 / for (int i = 1;
/// i <= 10; i++) { / System.out.println(factorial(i)); / } /
/// System.out.println("Total time " + (System.currentTimeMillis() - startTime));

		long startTime = System.currentTimeMillis(); // 1-1-1970
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 1; i < 10; i++) {
			int finalI = i;
			executor.submit(() -> {
				long result = factorial(finalI);
				System.out.println(result);
			});
		}

		executor.shutdown();
		try {
			executor.awaitTermination(100, TimeUnit.SECONDS); // wait karega 100 sec tak ye executor ke end hone ka nahi
																// to force fully karega.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Total time " + (System.currentTimeMillis() - startTime));
	}

	public static long factorial(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long result = 1;
		for (int j = 2; j <= i; j++) {
			result *= j;
		}
		return result;
	}
}

// class Demo {
//	public static void main(String[] args) {
//		Thread t = new Thread(() -> { // vo runnable state me hai nahi hai vo koi thread existentncec nahi hai conceputally hai.
//			System.out.println("Child Thread");
//		});
//		t.start();
//		t.start(); // runtime error.exception IllegalThreadStateException.
//		t.run();
//		System.out.println("Main Thread");
//	}
//}
