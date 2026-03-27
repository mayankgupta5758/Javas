package com.mayank.synchronizedoo;

public class Counter {
	private int count = 0;
	
	public synchronized void increment() { // critical section
		count++;
//		or 
		synchronized (this) {
		count++;	
		}
	}
//	raise cond. not use sync.

	public int getCount() {
		return count;
	}
}
