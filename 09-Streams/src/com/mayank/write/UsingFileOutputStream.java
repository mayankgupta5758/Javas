package com.mayank.write;

import java.io.FileOutputStream;

public class UsingFileOutputStream {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("src/test.txt", true);

	        String data = "/nHello Java using FileOutputStream";

	        fos.write(data.getBytes());

	        fos.close();

	        System.out.println("Data written successfully");
		} catch (Exception e) {
			System.out.println("Excception Occcur: " + e);
		}
	}

}
