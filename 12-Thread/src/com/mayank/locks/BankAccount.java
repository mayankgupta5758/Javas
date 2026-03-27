package com.mayank.locks;

//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.*;

public class BankAccount extends Thread {
	private int balance = 100;

//	inplicit sync.
	public synchronized void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " proceeding with withdraw " + amount);
			try {
				Thread.sleep(10000); // Here, jab t1 sleep ya db me chala gaya orp. perforrm kerna to t2 to wait kar
										// raha hai ave hi so we use lock
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " completing withdraw. Remaining amount " + amount);
		} else {
			System.out.println(Thread.currentThread().getName() + " insufficient balance");
		}
	}
	
//	private final Lock lock = new ReentrantLock();
//	public void withdraw(int amount) {
//		System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
//		try {
//			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
//				if (balance >= amount) {
//					try {
//						System.out.println(Thread.currentThread().getName() + " proceeding with withdraw " + amount);
//						Thread.sleep(3000);
//						balance -= amount;
//						System.out.println(Thread.currentThread().getName() + " completing withdraw. Remaining amount " + amount);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					} finally {
//						lock.unlock();
//					}
//					
//				} else {
//					System.out.println(Thread.currentThread().getName() + " insufficient balance");
//				}
//			} else {
//				System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try again later.");
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
