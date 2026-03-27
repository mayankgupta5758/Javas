package com.mayank.threadcommunication;

class SharedResource {
	private int data;
	private boolean hasData;

	public synchronized void produce(int value) {
		while (hasData) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt(); // to store it state
				e.printStackTrace();
			}
		}
		data = value;
		hasData = true;
		System.out.println("Produced: " + value);
		notify();
	}

	public synchronized int consume() {
		while (!hasData) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt(); // to store it state
				e.printStackTrace();
			}
		}
		hasData = false;
		System.out.println("Consumed: " + data);
		notify();
		return data;
	}
}

class Producer implements Runnable {

	private SharedResource resource;

	public Producer(SharedResource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			resource.produce(i);
		}
	}
}

class Consumer implements Runnable {

	private SharedResource resource;

	public Consumer(SharedResource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			resource.consume();
		}

	}

}

public class ThreadCommunication {
	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
		Thread producerThread = new Thread(new Producer(resource));
		Thread consumerThread = new Thread(new Consumer(resource));
		producerThread.start();
		consumerThread.start();
	}
}
