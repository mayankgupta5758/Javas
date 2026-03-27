package com.mayank.create;

import java.io.FileOutputStream;
import java.io.IOException;

public class UsingFileOutputStream {

	public static void main(String[] args) {
//		File (Disk) → FileInputStream → Program
//		Disk se har character read karne par access hota hai.
//		Disk access slow hota hai.
//		Isliye FileInputStream slow lagta hai.
		try {
			FileOutputStream fos = new FileOutputStream("src/data.txt");

	        String data = "Hello Java";

	        fos.write(data.getBytes());

	        fos.close();
		} catch(IOException e) {
			System.out.println("Excception Occcur: " + e);
		}
	}

}
