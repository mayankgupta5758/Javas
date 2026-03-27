package com.mayank.example;

//import java.util.Iterator;

public class ThreadMethod extends Thread {

	/*
	 * 1.
	 * @Override public void run() {
	 * System.out.println(Thread.currentThread().getName()); // Thread-0
	 * System.out.println("Hello"); try { Thread.sleep(5000); } catch
	 * (InterruptedException e) { e.printStackTrace(); } }
	 */

	public ThreadMethod(String threadName) { // We Can Change Thread Naam Too.
		super(threadName);
	}

	/*
	 * 2.
	 * @Override public void run() { for (int i = 0; i < 5; i++) { String a = "";
	 * for (int j = 0; j < 10000; j++) { a += "a"; }
	 * System.out.println(Thread.currentThread().getName() + " - Priority " +
	 * Thread.currentThread().getPriority() + " - count " + i);
	 * 
	 * try { Thread.sleep(100); } catch (Exception e) { // TODO: handle exception }
	 * } }
	 */

	/*
	 * 3.
	 * @Override public void run() { try { Thread.sleep(1000);
	 * System.out.println("Thread is sleeping..."); } catch (InterruptedException e)
	 * { System.out.println("Thread Intrupted: " + e); } }
	 */

	/*
	 * 4.
	 * @Override public void run() { for (int i = 0; i < 5; i++) {
	 * System.out.println(Thread.currentThread().getName() + " is running.");
	 * Thread.yield(); // chanche dena cheta hai dhusera process ko execute ke liya.
	 * } }
	 */

	@Override
//	Daemon Thread:- ye kya kerta hai ki background me chelta hai jvm iske liya wait nahi
//	kerta hai lakin main thread to ktm ho gaya hai to jvm terminate kar dega program ko
	public void run() {
		while (true) {
			System.out.println("Hello World!");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 1.
		 * ThreadMethod tm = new ThreadMethod("NYT"); tm.start(); tm.join();
		 * System.out.println("World"); // ye wait karega ki run method kab end hoga
		 * than niche wala run hoga.
		 */

		/*
		 * 2.
		 * ThreadMethod l = new ThreadMethod("Low PRIORITY Thread"); ThreadMethod m =
		 * new ThreadMethod("Medium PRIORITY Thread"); ThreadMethod h = new
		 * ThreadMethod("High PRIORITY Thread"); l.setPriority(Thread.MIN_PRIORITY);
		 * m.setPriority(Thread.NORM_PRIORITY); h.setPriority(Thread.MAX_PRIORITY);
		 * l.start(); m.start(); h.start(); // OS scheduler decide karta hai kaun
		 * chalega // CPU cores decide karte hain execution // Context switching hota ha
		 */

		/*
		 * 3.
		 * ThreadMethod l = new ThreadMethod("NYT"); l.start(); l.interrupt(); //
		 * sleep intrupt kardi na.
		 */

		/*
		 * 4.
		 * ThreadMethod t1 = new ThreadMethod("T1"); ThreadMethod t2 = new
		 * ThreadMethod("T2"); t1.start(); t2.start();
		 */

		ThreadMethod t1 = new ThreadMethod("T1");
		t1.setDaemon(true);
		t1.start();
		System.out.println("Main done...");
//		yaha pe t1 ko daemon thread set kar diya to fir vo st. hoga then vo sout print karega then hello world karega kuch time than
//		vo jvm use apne app terminarte kar dega
		
		ThreadMethod t2 = new ThreadMethod("T2");
		t2.start();
//		is case me jvm t2 jo ki user thread hai vo wait karega t2 ke end hone ka than exit karega.
	}
}
